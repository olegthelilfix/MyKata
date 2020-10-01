package me.olegthelilfix.mykata

/**
 * We want to create a simple interpreter of assembler which will support the following instructions:
 * mov x y - copies y (either a constant value or the content of a register) into register x
 * inc x - increases the content of the register x by one
 * dec x - decreases the content of the register x by one
 * jnz x y - jumps to an instruction y steps away (positive means forward, negative means backward, y can be a register or a constant), but only if x (a constant or a register) is not zero
 * origin https://www.codewars.com/kata/58e24788e24ddee28e000053/train/kotlin
 */
fun interpret(program: Array<String>): Map<String, Int> {
    val storage: MutableMap<String, Int> = mutableMapOf()

    val instructions = program.map { Instruction(it) }

    var pointer = 0

    while (pointer < instructions.size) {
        val currentCommand = instructions[pointer]
        when(currentCommand.operation) {
            "mov" -> {
                storage[currentCommand.firstOperand] = parseIntOrGetFromStorage(currentCommand.secondOperand, storage)
                pointer++
            }
            "inc" -> {
                storage[currentCommand.firstOperand] = storage[currentCommand.firstOperand]?.plus(1) ?: 0
                pointer++
            }
            "dec" -> {
                storage[currentCommand.firstOperand] = storage[currentCommand.firstOperand]?.minus(1) ?: 0
                pointer++
            }
            "jnz" -> {
                if(storage[currentCommand.firstOperand] == 0) {
                    pointer++
                }
                else {
                    pointer += parseIntOrGetFromStorage(currentCommand.secondOperand, storage)
                }
            }
        }
    }

    return storage
}

private fun parseIntOrGetFromStorage(operand: String?, storage: MutableMap<String, Int>): Int = operand?.toIntOrNull() ?: storage[operand] ?: 1

private class Instruction(word: String) {
    val operation: String
    val firstOperand: String
    val secondOperand: String?

    init {
        val commands = word.split(" ")
        operation = commands[0]
        firstOperand = commands[1]
        secondOperand = if (commands.size == 3) commands[2] else null
    }
}
