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
    private final BufferedImage MenuBackground;
    private final BufferedImage Button1;
    private final BufferedImage Button1v2;
    private final BufferedImage Button2;
    private final BufferedImage Button2v2;
    private final BufferedImage Button3;
    private final BufferedImage Button3v2;
    private final BufferedImage Button4;
    private final BufferedImage Button5;
    private final BufferedImage Button4v2;
    private final BufferedImage Button5v2;
    private final BufferedImage Button6;
    private final BufferedImage Button6v2;
    private final BufferedImage SecondMenuBackground;
    private final BufferedImage infectedWall;
    private final BufferedImage imanPower;
    private final BufferedImage coinsPower;
    private final BufferedImage sheildPower;
    private final BufferedImage imanPowerv2;
    private final BufferedImage coinsPowerv2;
    private final BufferedImage sheildPowerv2;
    private final BufferedImage ImanSprite1;
    private final BufferedImage ImanSprite2;
    private final BufferedImage SheildSprite1;
    private final BufferedImage SheildSprite2;
    private final BufferedImage CoinsSprite1;
    private final BufferedImage CoinsSprite2;
    private final BufferedImage wallet;
    private final BufferedImage Zero;
    private final BufferedImage One;
    private final BufferedImage Two;
    private final BufferedImage Three;
    private final BufferedImage Four;
    private final BufferedImage Five;
    private final BufferedImage Six;
    private final BufferedImage Seven;
    private final BufferedImage Eight;
    private final BufferedImage Nine;
    private final BufferedImage finalMenu;


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
        this.MenuBackground = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/mainMenu.png")));
        this.Button1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao1.png")));
        this.Button2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao2.png")));
        this.Button3 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao3.png")));
        this.Button1v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao1v2.png")));
        this.Button2v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao2v2.png")));
        this.Button3v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao3v2.png")));
        this.Button4 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao4.png")));
        this.Button4v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao4v2.png")));
        this.Button5 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao5.png")));
        this.Button5v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao5v2.png")));
        this.Button6 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao6.png")));
        this.Button6v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao6v2.png")));
        this.SecondMenuBackground = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/secondMenu.png"))));
        this.infectedWall = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/infectedWall.png")));
        this.sheildPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/sheild.png")));
        this.coinsPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/coins.png")));
        this.imanPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/iman.png")));
        this.sheildPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/sheildv2.png")));
        this.coinsPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/coinsv2.png")));
        this.imanPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/imanv2.png")));
        this.ImanSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/iman.png")));
        this.ImanSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/imanv2.png")));
        this.SheildSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/sheild.png")));
        this.SheildSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/sheildv2.png")));
        this.wallet = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/UI/wallet2.png")));
        this.Zero = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/0.png")));
        this.One = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/1.png")));
        this.Two = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/2.png")));
        this.Three = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/3.png")));
        this.Four = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/4.png")));
        this.Five = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/5.png")));
        this.Six = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/6.png")));
        this.Seven = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/7.png")));
        this.Eight = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/8.png")));
        this.Nine = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/9.png")));
        this.finalMenu = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/finaLmenu.png"))));
        this.CoinsSprite1 = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/doubleCoins.png"))));
        this.CoinsSprite2 = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/doubleCoinsv2.png"))));

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
        this.MenuBackground = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/mainMenu.png")));
        this.Button1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao1.png")));
        this.Button2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao2.png")));
        this.Button3 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao3.png")));
        this.Button1v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao1v2.png")));
        this.Button2v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao2v2.png")));
        this.Button3v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/mainMenu/botao3v2.png")));
        this.Button4 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao4.png")));
        this.Button4v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao4v2.png")));
        this.Button5 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao5.png")));
        this.Button5v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao5v2.png")));
        this.Button6 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao6.png")));
        this.Button6v2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/botao6v2.png")));
        this.SecondMenuBackground = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/secondMenu.png"))));
        this.infectedWall = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/infectedWall.png")));
        this.sheildPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/sheild.png")));
        this.coinsPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/coins.png")));
        this.imanPower = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/iman.png")));
        this.sheildPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/shieldv2.png")));
        this.coinsPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/coinsv2.png")));
        this.imanPowerv2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/imanv2.png")));
        this.ImanSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/iman.png")));
        this.ImanSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/imanv2.png")));
        this.SheildSprite1 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/shield.png")));
        this.SheildSprite2 = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/map/shieldv2.png")));
        this.wallet = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/UI/wallet2.png")));
        this.Zero = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/0.png")));
        this.One = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/1.png")));
        this.Two = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/2.png")));
        this.Three = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/3.png")));
        this.Four = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/4.png")));
        this.Five = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/5.png")));
        this.Six = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/6.png")));
        this.Seven = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/7.png")));
        this.Eight = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/8.png")));
        this.Nine = ImageIO.read(Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/font/9.png")));
        this.finalMenu = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/endMenu/finaLmenu.png"))));
        this.CoinsSprite1 = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/doubleCoins.png"))));
        this.CoinsSprite2 = ImageIO.read((Objects.requireNonNull(LanternaGUI.class.getClassLoader().getResource("sprites/powerupsMenu/doubleCoinsv2.png"))));

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
            dir = 0;
            return ACTION.RIGHT;
        }
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) {
            dir = 1;
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

    public void drawNonPos(BufferedImage sprite, int yOffset, int xOffset) throws IOException {

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
                    graphics.setCharacter(xOffset + x, yOffset + y, c);
                }
            }
        }
    }

    private BufferedImage rotateSprite(BufferedImage sprite, double angle) {
        int WIDTH = 16;
        int HEIGHT = 16;

        BufferedImage rotatedImage = new BufferedImage(WIDTH, HEIGHT, sprite.getType());
        Graphics2D g2d = rotatedImage.createGraphics();
        g2d.rotate(Math.toRadians(angle), WIDTH / 2.0, HEIGHT / 2.0);
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
    public void drawMenu(Position position) {
        try {
            drawImage(position, this.MenuBackground);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawSecondMenu(Position position) {
        try {
            drawImage(position, this.SecondMenuBackground);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawFinalMenu(Position position) {
        try {
            drawImage(position, this.finalMenu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage getButtonSprite(int buttonNumber, boolean isSelected) {
        return switch (buttonNumber) {
            case 1 -> isSelected ? Button1v2 : Button1;
            case 2 -> isSelected ? Button2v2 : Button2;
            case 3 -> isSelected ? Button3v2 : Button3;
            default -> Button1;
        };
    }

    private BufferedImage getCompletedButtonSprite(int buttonNumber, boolean isSelected) {
        return switch (buttonNumber) {
            case 1 -> isSelected ? Button5v2 : Button5;
            case 2 -> isSelected ? Button4v2 : Button4;
            case 3 -> isSelected ? Button6v2 : Button6;
            default -> Button5v2;
        };
    }

    private BufferedImage getFailedButtonSprite(int buttonNumber, boolean isSelected) {
        return switch (buttonNumber) {
            case 1 -> isSelected ? Button4v2 : Button4;
            case 2 -> isSelected ? Button6v2 : Button6;
            default -> Button4v2;
        };
    }

    private BufferedImage getPowerButtonSprite(int buttonNumber, boolean isSelected) {
        return switch (buttonNumber) {
            case 1 -> isSelected ? sheildPowerv2 : sheildPower;
            case 2 -> isSelected ? coinsPowerv2 : coinsPower;
            case 3 -> isSelected ? imanPowerv2 : imanPower;
            case 4 -> isSelected ? Button6v2 : Button6;

            default -> sheildPowerv2;
        };
    }

    @Override
    public void drawPower1(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getPowerButtonSprite(1, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawPower2(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getPowerButtonSprite(2, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawPower3(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getPowerButtonSprite(3, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawReturn(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getPowerButtonSprite(4, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCompleteButton1(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getCompletedButtonSprite(1, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCompleteButton2(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getCompletedButtonSprite(2, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawFailedButton1(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getFailedButtonSprite(1, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawFailedButton2(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getFailedButtonSprite(2, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawCompleteButton3(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getCompletedButtonSprite(3, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawButton1(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getButtonSprite(1, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawButton2(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getButtonSprite(2, isSelected);
            drawImage(position, buttonSprite);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawButton3(Position position, boolean isSelected) {
        try {
            BufferedImage buttonSprite = getButtonSprite(3, isSelected);
            drawImage(position, buttonSprite);
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
    public void drawTrap(Position position) {
        try {
            drawImage(position, this.infectedWall);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawScore(int number) throws IOException {
        int yOffset = 12;
        int xOffset = 245;

        if (number == 0) {
            drawNonPos(Zero, yOffset, xOffset);
            drawNonPos(Zero, yOffset, xOffset - 10);
            drawNonPos(Zero, yOffset, xOffset - 20);
            drawNonPos(Zero, yOffset, xOffset - 30);
        }
        while (number != 0) {
            int digit = number % 10;
            switch (digit) {
                case 0 -> drawNonPos(Zero, yOffset, xOffset);
                case 1 -> drawNonPos(One, yOffset, xOffset);
                case 2 -> drawNonPos(Two, yOffset, xOffset);
                case 3 -> drawNonPos(Three, yOffset, xOffset);
                case 4 -> drawNonPos(Four, yOffset, xOffset);
                case 5 -> drawNonPos(Five, yOffset, xOffset);
                case 6 -> drawNonPos(Six, yOffset, xOffset);
                case 7 -> drawNonPos(Seven, yOffset, xOffset);
                case 8 -> drawNonPos(Eight, yOffset, xOffset);
                case 9 -> drawNonPos(Nine, yOffset, xOffset);
            }
            xOffset -= 10;

            number /= 10;
        }
    }

    @Override
    public void drawIman(Position position, int powerColor) {
        try {
            if (powerColor == 1) {
                drawImage(position, this.ImanSprite1);
            } else {
                drawImage(position, this.ImanSprite2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawSheild(Position position, int powerColor) {
        try {
            if (powerColor == 1) {
                drawImage(position, this.SheildSprite1);
            } else {
                drawImage(position, this.SheildSprite2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawDoubleCoins(Position position, int powerColor) {
        try {
            if (powerColor == 1) {
                drawImage(position, this.CoinsSprite1);
            } else {
                drawImage(position, this.CoinsSprite2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void drawWallet() {
        BufferedImage sprite = this.wallet;
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
                    graphics.setCharacter(x + 190, y + 8, c);
                }
            }
        }
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
