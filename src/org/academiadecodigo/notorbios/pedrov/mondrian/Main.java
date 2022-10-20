package org.academiadecodigo.notorbios.pedrov.mondrian;

import org.academiadecodigo.notorbios.pedrov.mondrian.settings.Settings;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        /*

             __  __    ____    _   _   _____    _____    _____              _   _
            |  \/  |  / __ \  | \ | | |  __ \  |  __ \  |_   _|     /\     | \ | |
            | \  / | | |  | | |  \| | | |  | | | |__) |   | |      /  \    |  \| |
            | |\/| | | |  | | | . ` | | |  | | |  _  /    | |     / /\ \   | . ` |
            | |  | | | |__| | | |\  | | |__| | | | \ \   _| |_   / ____ \  | |\  |
            |_|  |_|  \____/  |_| \_| |_____/  |_|  \_\ |_____| /_/    \_\ |_| \_|

            With Library: Simple Graphics Library [https://github.com/academia-de-codigo/simple-graphics]

        */

        Mondrian app = new Mondrian();

        Frame.getFrames()[Settings.questionSettings ? 1 : 0].toFront();
    }

}