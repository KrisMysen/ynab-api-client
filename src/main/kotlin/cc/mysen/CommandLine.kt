package cc.mysen

import cc.mysen.commandline.Input
import cc.mysen.commandline.Output
import cc.mysen.files.InputFolders

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

        actions.write()
    }

    interface Action {

        fun print()

        fun run()
    }

    private class Actions(private val output: Output, private val input: Input) {

        private var actions: List<Action> = ArrayList()

        fun add(action: Action): Actions {
            actions = actions.plus(action)
            return this
        }

        fun write() {
            output.newLine()
            output.write("What do you want to do?")

            actions.forEach { it.print() }

            input.read { onInputReceived(it)}
        }

        fun onInputReceived(text: String) {
            when (text) {
                "1" -> output.write("Good choice. Processing....")
                "2" -> output.write("Too bad, exiting")
            }

            input.read { onInputReceived(it)}
        }

    }

    private class StatusAction(
        private val output: Output,
        private val inputFolders: InputFolders
        ) : Action {

        override fun print() {
            output.write("Status")
        }

        override fun run() {
            output.write("Starting detection of input files...")
            val inputFolders = inputFolders.get()

            if (inputFolders.isNotEmpty()) {
                output.write("Detected ${inputFolders.size} folders")
                inputFolders.forEach {
                    output.write("\t-${it.name} (${it.getFiles().size} files)")
                }
            }
        }
    }

    private class ProcessAction(private val output: Output): Action {
        override fun print() {
            output.write("Process transactions")
        }

        override fun run() {
            TODO("Not yet implemented")
        }
    }

    private class ExitAction(private val output: Output): Action {
        override fun print() {
            output.write("Exit")
        }

        override fun run() {
            TODO("Not yet implemented")
        }
    }

}