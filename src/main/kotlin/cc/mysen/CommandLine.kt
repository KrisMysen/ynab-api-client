package cc.mysen

import cc.mysen.commandline.Input
import cc.mysen.commandline.Output
import cc.mysen.files.InputFolders
import kotlin.system.exitProcess

class CommandLine(
        private val input: Input,
        private val output: Output,
        private val inputFolders: InputFolders
) {

    fun init() {

        val actions = Actions(output, input)
        actions.add(StatusAction(output, inputFolders))
        actions.add(ProcessAction(output))
        actions.add(ExitAction(output))

        actions.printActions()
    }

    interface Action {

        fun print(index: Int)

        fun execute(onDone: () -> Unit)
    }


    private class Actions(private val output: Output, private val input: Input) {

        private var actions: List<Action> = ArrayList()

        fun add(action: Action): Actions {
            actions = actions.plus(action)
            return this
        }

        fun printActions() {
            output.newLine()
            output.write("What do you want to do?")

            actions.forEachIndexed { index, action ->  action.print(index) }

            input.read { onInputReceived(it)}
        }

        fun onInputReceived(text: String) {
            actions[text.toInt()]
                .execute {
                    printActions()
                }
        }

    }

    private class StatusAction(
        private val output: Output,
        private val inputFolders: InputFolders
        ) : Action {

        override fun print(index: Int) {
            output.write("${index}. Status")
        }

        override fun execute(onDone: () -> Unit) {
            output.write("Starting detection of input files...")
            val inputFolders = inputFolders.get()

            if (inputFolders.isNotEmpty()) {
                output.write("Detected ${inputFolders.size} folders")

                inputFolders.forEach {
                    output.write("\t-${it.name} (${it.getFiles().size} files)")
                }
            }
            output.write("Done")
            onDone()
        }
    }

    private class ProcessAction(private val output: Output): Action {

        override fun print(index: Int) {
            output.write("${index}. Process transactions")
        }

        override fun execute(onDone: () -> Unit) {
            output.write("Processing transactions...")
            output.write("Done")
            onDone()
        }
    }

    private class ExitAction(private val output: Output): Action {

        override fun print(index: Int) {
            output.write("${index}. Exit")
        }

        override fun execute(onDone: () -> Unit) {
            exitProcess(0)
        }
    }

}