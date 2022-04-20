import kotlin.math.abs
import java.util.Scanner

import com.github.ajalt.mordant.rendering.TextColors.*


fun main(args: Array<String>) {
    // Empty 2DArray
    fun array2D(): Array<IntArray> {

        val tableSize = 50
        //Init
        val table = Array(tableSize) { IntArray(3) }

        for (i in table.indices) {
            val rowTable = IntArray(tableSize)
            for (n in rowTable.indices) rowTable[n] = 0
            table[i] = rowTable
        }
        return table

    }

    // Print table with color
    fun printArray(table: Array<IntArray>) {

        val arrayStr = table.contentDeepToString()

        println(
            arrayStr.replace("[", "").replace("], ", "\n").replace(", ", "").replace(
                "]]", ""
            ).replace("0", (black on black)("  ")).replace("1", (white on white)("  "))
        )
    }

    // Rules
    fun state(table: Array<IntArray>, y: Int, x: Int): String {
        var cells = 0

        if (table[abs((table.size + y).rem(table.size))][abs((table.size + (x + 1)).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + y).rem(table.size))][abs((table.size + (x - 1)).rem(table.size))] == 1) {
            cells++

        }
        if (table[abs((table.size + (y + 1)).rem(table.size))][abs((table.size + x).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + (y - 1)).rem(table.size))][abs((table.size + x).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + (y + 1)).rem(table.size))][abs((table.size + (x + 1)).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + (y - 1)).rem(table.size))][abs((table.size + (x - 1)).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + (y + 1)).rem(table.size))][abs((table.size + (x - 1)).rem(table.size))] == 1) {
            cells++
        }
        if (table[abs((table.size + (y - 1)).rem(table.size))][abs((table.size + (x + 1)).rem(table.size))] == 1) {
            cells++
        }

        // Birth
        return if (table[y][x] == 0 && cells == 3) {
            "Birth"
            // Live
        } else if (table[y][x] == 1 && (cells == 2 || cells == 3)) {
            "Live"

            // Death
        } else if (table[y][x] == 1 && (cells < 2 || cells > 3)) {
            "Death"
            // Nothing
        } else {
            "Nothing"
        }

    }

    // Initialization
    var table1 = array2D()
    var table2 = array2D()
    var y = 0
    var x = 0

    // Spaceship
    table1[25][25] = 1
    table1[26][26] = 1
    table1[27][26] = 1
    table1[27][25] = 1
    table1[27][24] = 1

    // Blinker
    table1[5][5] = 1
    table1[6][5] = 1
    table1[7][5] = 1

    // Block

    table1[40][10] = 1
    table1[40][11] = 1
    table1[41][10] = 1
    table1[41][11] = 1

    // Initial situation
    printArray(table1)
    val input = Scanner(System.`in`)
    print("Press Enter to continue...")
    input.nextLine()

    // Start Loop
    while (true) {

        // Check case
        for (row in table1) {
            for (j in row) {
                when (state(table1, y, x)) {
                    "Birth" -> {

                        table2[y][x] = 1
                    }
                    "Death" -> {
                        table2[y][x] = 0

                    }
                    "Live" -> {
                        table2[y][x] = 1
                    }
                    "Nothing" -> table2[y][x] = table2[y][x]
                }
                x++
            }
            x = 0
            y++
        }
        y = 0

        // Print Array + Wait 1/4s
        printArray(table2)
        val inputCmd = Scanner(System.`in`)
        inputCmd.nextLine()
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n")

        // Empty table
        table1 = table2
        table2 = array2D()

    }

}
