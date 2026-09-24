/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utills;

/**
 *
 * @author Alfareza
 */

import java.time.Year;

public class IdGenerator {

    private static int nomorUrut = 1;

    private IdGenerator() {
        // Mencegah class dibuat menjadi object
    }

    public static int generateId() {

        int tahun = Year.now().getValue();

        return (tahun * 1000) + nomorUrut++;
    }
}
