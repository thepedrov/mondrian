<p align="center">
    <img src="https://i.ibb.co/y4pcYkS/print1.png">
</p>

# Mondrian
Mondrian is a small app that lets you paint **Piet Mondrian’s** minimalist art style.

## Download
Go to the [Releases](https://github.com/thepedrov/mondrian/releases) to download the latest JAR.

## Screenshots
<p align="center">
  <img src="https://i.ibb.co/SNdn4pS/screenshots.png">
</p>

## Add more colors
On line 14 of class KeyboardSettings add (put) the key and the color (in rgb).
```
public static final HashMap<Integer, Color> keyPaintColor = new HashMap<Integer, Color>() {{
    put(KeyboardEvent.KEY_SPACE, new Color(255, 255, 255)); // White
    put(KeyboardEvent.KEY_1, new Color(0, 0, 0)); // Black
    put(KeyboardEvent.KEY_2, new Color(224, 229, 231)); // White Gray
    put(KeyboardEvent.KEY_3, new Color(0, 144, 255)); // Blue
    put(KeyboardEvent.KEY_4, new Color(255, 0, 0)); // Red
    put(KeyboardEvent.KEY_5, new Color(255, 248, 0)); // Yellow
}};
```

## Tech stack & Open-source libraries
- Minimum SDK Java Version 8
- [Simple Graphics Library](https://github.com/academia-de-codigo/simple-graphics)
