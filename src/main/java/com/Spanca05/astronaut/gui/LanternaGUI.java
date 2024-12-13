package com.Spanca05.astronaut.gui;

import com.Spanca05.astronaut.model.Position;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class LanternaGUI implements GUI {
    private final Screen screen;
    private static final int BLOCK_SIZE = 16;
    private int dir = 0; // 0 =right, 1 = left
    private final BufferedImage WallSprite;
    private final BufferedImage SpikeSprite;
    private final BufferedImage NautaSprite1;
    private final BufferedImage NautaSprite2;
    private final BufferedImage NautaSprite3;
    private final BufferedImage NautaSprite4;
    private final BufferedImage EndBlockSprite1;
    private final BufferedImage EndBlockSprite2;
    private final BufferedImage Point1Sprite;
    private final BufferedImage Point2Sprite;
    private final BufferedImage Coin1Sprite;
    private final BufferedImage Coin2Sprite;
    private final BufferedImage StarSprite1;
    private final BufferedImage StarSprite2;


    public LanternaGUI(Screen screen) throws IOException {
        this.screen = screen;
        this.Point1Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/point1.png")));
        this.Point2Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/point2.png")));
        this.EndBlockSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/endBlock.png")));
        this.EndBlockSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/endBlock3.png")));
        this.WallSprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/wall.png")));
        this.SpikeSprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/spikes.png")));
        this.NautaSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation1.png")));
        this.NautaSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation2.png")));
        this.NautaSprite3 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation3.png")));
        this.NautaSprite4 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation4.png")));
        this.Coin1Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/coin1.png")));
        this.Coin2Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/coin2.png")));
        this.StarSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/star1.png")));
        this.StarSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/star2.png")));

    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
        this.WallSprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/wall.png")));
        this.SpikeSprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/spikes.png")));
        this.Point1Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/point1.png")));
        this.Point2Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/point2.png")));
        this.NautaSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation1.png")));
        this.NautaSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation2.png")));
        this.NautaSprite3 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation3.png")));
        this.NautaSprite4 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/character/nauta-idle-animation4.png")));
        this.EndBlockSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/endBlock.png")));
        this.EndBlockSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/endBlock3.png")));
        this.Coin1Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/coin1.png")));
        this.Coin2Sprite = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/coin2.png")));
        this.StarSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/star1.png")));
        this.StarSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/star2.png")));

    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/square.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 3);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'Q') return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) {
            dir=0;
            return ACTION.RIGHT;
        }
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
            dir=1;
            return ACTION.LEFT;
        }

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    public void drawImage(Position position, BufferedImage sprite) throws IOException {
        if (position.getX() < 0 || position.getX() > 17 || position.getY() < 0 || position.getY() > 15) return;

        TextGraphics graphics = screen.newTextGraphics();
        for (int x = 0; x < sprite.getWidth(); x++) {
            for (int y = 0; y < sprite.getHeight(); y++) {
                int a = sprite.getRGB(x, y);
                int alpha = (a >> 24) & 0xff;
                int red = (a >> 16) & 255;
                int green = (a >> 8) & 255;
                int blue = a & 255;

                if (alpha != 0) {
                    TextCharacter c = new TextCharacter(' ', new TextColor.RGB(red, green, blue), new TextColor.RGB(red, green, blue));
                    graphics.setCharacter(position.getX() * BLOCK_SIZE + x, position.getY() * BLOCK_SIZE + y + 1, c);
                }
            }
        }
    }

    private BufferedImage rotateSprite(BufferedImage sprite, double angle) {
        int WIDTH = 16;
        int HEIGHT = 16;

        BufferedImage rotatedImage = new BufferedImage(WIDTH, HEIGHT, sprite.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(angle), WIDTH / 2.0, HEIGHT/ 2.0);
        g2d.drawImage(sprite, 0, 0, null);
        g2d.dispose();
        return rotatedImage;
    }




    @Override
    public void drawAstronaut(Position position, int spriteNumber, int angle) {
        try {
            BufferedImage sprite;
            if (dir == 0) { // right
                sprite = (spriteNumber == 1) ? NautaSprite1 : NautaSprite2;
            } else { // left
                sprite = (spriteNumber == 1) ? NautaSprite3 : NautaSprite4;
            }
            BufferedImage rotatedSprite = rotateSprite(sprite, angle);
            drawImage(position, rotatedSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void drawWall(Position position) {
        try {
            drawImage(position, this.WallSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void drawEndBlock(Position position, int endBlockColor) {
        try {
            if (endBlockColor == 1) {
                drawImage(position, this.EndBlockSprite1);
            } else {
                drawImage(position, this.EndBlockSprite2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawPoint(Position position, int spriteNumber) {
        try {
            if (spriteNumber == 1) {
                drawImage(position, this.Point1Sprite);
            } else {
                drawImage(position, this.Point2Sprite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCoin(Position position, int coinColor) {
        try {
            if (coinColor == 1) {
                drawImage(position, this.Coin1Sprite);
            } else {
                drawImage(position, this.Coin2Sprite);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawStar(Position position, int starColor) {
        try {
            if (starColor == 1) {
                drawImage(position, this.StarSprite1);
            } else {
                drawImage(position, this.StarSprite2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawSpike(Position position) {
        try {
            drawImage(position, this.SpikeSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawMonster(Position position) {
        drawCharacter(position.getX(), position.getY(), 'M', "#669900");
    }


    @Override
    public void drawTrap(Position position) {
        drawCharacter(position.getX(), position.getY(), '█', "#25C8FF");
    }


    @Override
    public void drawIman(Position position) {
        drawCharacter(position.getX(), position.getY(), 'I', "#FFA500");
    }

    @Override
    public void drawEscudo(Position position) {
        drawCharacter(position.getX(), position.getY(), 'U', "#FFC0CB");
    }


    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        TextGraphics tg = this.screen.newTextGraphics();
        tg.setBackgroundColor(TextColor.ANSI.BLACK);
        tg.fillRectangle(new TerminalPosition(0, 0), this.screen.getTerminalSize(), ' ');
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}