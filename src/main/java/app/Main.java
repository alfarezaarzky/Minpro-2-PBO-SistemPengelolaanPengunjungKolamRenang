/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

/**
 *
 * @author Alfareza
 */

import controller.ManajemenPengunjung;
import view.PengunjungView;

public class Main {

    public static void main(String[] args) {

        ManajemenPengunjung manajemen =
                new ManajemenPengunjung();

        PengunjungView view =
                new PengunjungView();

        view.jalankanProgram(manajemen);
    }
}