package org.academiadecodigo.notorbios.pedrov.mondrian.settings;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.HashMap;

public class KeyboardSettings {

    // Keys VS Colors
    public static final HashMap<Integer, Color> keyPaintColor = new HashMap<Integer, Color>() {{
        put(KeyboardEvent.KEY_SPACE, new Color(255, 255, 255)); // White
        put(KeyboardEvent.KEY_1, new Color(0, 0, 0)); // Black
        put(KeyboardEvent.KEY_2, new Color(224, 229, 231)); // White Gray
        put(KeyboardEvent.KEY_3, new Color(0, 144, 255)); // Blue
        put(KeyboardEvent.KEY_4, new Color(255, 0, 0)); // Red
        put(KeyboardEvent.KEY_5, new Color(255, 248, 0)); // Yellow
    }};

    // Events
    public static void startKeyboard(KeyboardHandler keyboardHandler) {
        Keyboard keyboard = new Keyboard(keyboardHandler);

        KeyboardEvent keyboardEvent;

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_UP);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_A);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_A);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_W);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_W);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_D);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_D);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_S);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEvent);

        keyboardEvent = new KeyboardEvent();
        keyboardEvent.setKey(KeyboardEvent.KEY_S);
        keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(keyboardEvent);

        for (Integer key : keyPaintColor.keySet()) {
            keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(key);
            keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyboardEvent);

            keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(key);
            keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboard.addEventListener(keyboardEvent);
        }
    }

}