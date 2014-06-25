package sum.ereignis;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Bildschirm extends JFrame implements FocusListener, KeyListener, MouseMotionListener, MouseListener, ComponentListener, WindowListener {

    public static Bildschirm hatPrivatschirm;
    private JPanel hatPanel;
    public static Bildschirm topFenster;
    protected static int zFensternummer;
    private Ereignisanwendung kenntEreignisanwendung;
    private Color zHintergrundfarbe = Color.white;
    private Image dbImage = null;
    private Graphics2D dbGraphics = null;
    private int zHoehe = 0;
    private int zBreite = 0;
    private boolean zHatFocus = true;
    private boolean zHatGezeichnet = false;
    private boolean zMitDoubleBuffering;
    Graphics2D g2d;

    public Bildschirm() {
        this(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), false);
    }

    public Bildschirm(boolean pMitDoubleBuffering) {
        this(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
    }

    public Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe) {
        this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
    }

    public Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering) {
        this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
    }

    public Bildschirm(int pBreite, int pHoehe) {
        this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
    }

    public Bildschirm(int pBreite, int pHoehe, boolean pMitDoubleBuffering) {
        this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
    }

    protected Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering) {
        super(pName);
        if (hatPrivatschirm == null) {
            hatPrivatschirm = this;
        }
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.zMitDoubleBuffering = pMitDoubleBuffering;
        this.kenntEreignisanwendung = Ereignisanwendung.hatSuMPrivateAnwendung;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().startsWith("mac os")) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
        }
        setJMenuBar(new JMenuBar());
        this.hatPanel = ((JPanel) getContentPane());
        this.hatPanel.setLayout(null);
        if (osName.toLowerCase().startsWith("mac os")) {
            this.hatPanel.setBounds(0, 0, 2000, 2000);
        } else {
            this.hatPanel.setBounds(0, 22, 2000, 2022);
        }
        this.hatPanel.setOpaque(true);
        addWindowListener(this);
        addComponentListener(this);
        this.hatPanel.addMouseMotionListener(this);
        this.hatPanel.addMouseListener(this);
        this.hatPanel.addKeyListener(this);
        this.hatPanel.addFocusListener(this);
        if (pBreite == -1) {
            Dimension dimension = getToolkit().getScreenSize();
            pBreite = dimension.width - 20;
            pHoehe = dimension.height - 60;
        }
        setBounds(pLinks, pOben, pBreite, pHoehe);
        setVisible(true);
        getJMenuBar().setVisible(true);
        fenstergroesseAnpassen();
        setSize(getWidth() - breite() + pBreite, getHeight() - hoehe() + pHoehe);

        if (this.zMitDoubleBuffering) {
            this.dbImage = createImage(getSize().width, getSize().height);
            this.dbGraphics = ((Graphics2D) this.dbImage.getGraphics());
        }
        init2DGraphics();
        setzeFarbe(11);
        bearbeiteFokusErhalten();
        warte(1000L);
        this.hatPanel.requestFocus();
    }

    protected void init2DGraphics() {

        if (this.zMitDoubleBuffering) {
            g2d = this.dbGraphics;
        } else {
            g2d = (Graphics2D) this.hatPanel.getGraphics();
        }
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

        g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.hatPanel.paint(g2d);
    }

    public JPanel privatPanel() {
        return this.hatPanel;
    }

    protected void bearbeiteFokusErhalten() {
        topFenster = this;
    }

    protected void merkeGroesse(int x, int y) {
        this.zBreite = x;
        this.zHoehe = y;
    }

    public Graphics g() {
        if (this.zMitDoubleBuffering) {
            return this.dbGraphics;
        }
        return this.hatPanel.getGraphics();
    }
    /*
     @Override
     public void paint(Graphics g) {
     System.out.println("paint");
     super.paint(g2d);
        
     hatPanel.paint(g2d);
     if (this.dbImage != null) {
     g2d.drawImage(this.dbImage, 0, 0, this);
     } else {
     super.paint(g2d);
     }

     }
     */

    @Override
    public void update(Graphics g) {

        super.update(g);
        if (this.zHatGezeichnet) {
            this.kenntEreignisanwendung.bearbeiteUpdate();
        } else if ((isVisible()) && (this.kenntEreignisanwendung.fuehrtAus())) {
            this.zHatGezeichnet = true;
            loescheAlles();
        }
    }

    public void zeichneDich() {
        if (this.zMitDoubleBuffering) {
            this.hatPanel.getGraphics().drawImage(this.dbImage, 0, 0, this);
        }
        for (int i = 0; i < this.hatPanel.getComponentCount(); i++) {
            Component komponente = this.hatPanel.getComponent(i);
            komponente.repaint();
        }
    }

    public boolean besitztFokus() {
        return this.zHatFocus;
    }

    public void setzeFokus() {
        this.hatPanel.requestFocus();
    }

    public void setzeFarbe(Color pFarbe) {
        if (this.zMitDoubleBuffering) {
            this.dbGraphics.setBackground(pFarbe);
            this.dbGraphics.clearRect(0, 0, 2000, 2000);
        } else {
            this.hatPanel.setBackground(pFarbe);
            this.hatPanel.getGraphics().clearRect(0, 0, 2000, 2000);
        }
        this.zHintergrundfarbe = pFarbe;
        this.hatPanel.paintImmediately(0, 0, 2000, 2000);
        this.hatPanel.validate();
        for (int i = 0; i < this.hatPanel.getComponentCount(); i++) {
            Component komponente = this.hatPanel.getComponent(i);
            komponente.setBackground(pFarbe);
            // komponente.repaint();
        }
    }

    public void setzeFarbe(int pFarbe) {
        if (pFarbe < 0) {
            pFarbe = 0;
        }
        pFarbe %= 13;
        switch (pFarbe) {
            case 0:
                setzeFarbe(Color.black);
                break;
            case 1:
                setzeFarbe(Color.blue);
                break;
            case 2:
                setzeFarbe(Color.cyan);
                break;
            case 3:
                setzeFarbe(Color.darkGray);
                break;
            case 4:
                setzeFarbe(Color.gray);
                break;
            case 5:
                setzeFarbe(Color.green);
                break;
            case 6:
                setzeFarbe(Color.lightGray);
                break;
            case 7:
                setzeFarbe(Color.magenta);
                break;
            case 8:
                setzeFarbe(Color.orange);
                break;
            case 9:
                setzeFarbe(Color.pink);
                break;
            case 10:
                setzeFarbe(Color.red);
                break;
            case 11:
                setzeFarbe(Color.white);
                break;
            case 12:
                setzeFarbe(Color.yellow);
        }
    }

    public void loescheAlles() {
        setzeFarbe(this.zHintergrundfarbe);
    }

    protected void warte(long zeit) {
        try {
            Thread.sleep(zeit);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    public Color hintergrundfarbe() {
        return this.zHintergrundfarbe;
    }

    public void doUpdate(JComponent pKomponente) {
        pKomponente.paintImmediately(0, 0, pKomponente.getWidth(), pKomponente.getHeight());

        pKomponente.validate();
    }

    public int breite() {
        return this.zBreite;
    }

    public int hoehe() {
        return this.zHoehe;
    }

    public void verstecke() {
        setVisible(false);
    }

    public void zeige() {
        setVisible(true);
    }

    public void immerNachVorn() {
        setAlwaysOnTop(true);
    }

    public void nachVorn() {
        toFront();
    }

    public void nachHinten() {
        toBack();
    }

    public void gibFrei() {
        fensterZerstoeren();
    }

    private void fenstergroesseAnpassen() {
        merkeGroesse(this.hatPanel.getVisibleRect().width, this.hatPanel.getVisibleRect().height);
        if (this.zMitDoubleBuffering) {
            this.dbImage = createImage(getSize().width, getSize().height);
            this.dbGraphics = ((Graphics2D) this.dbImage.getGraphics());
            init2DGraphics();
            setzeFarbe(this.zHintergrundfarbe);
        }
    }

    private void fensterZerstoeren() {
        if (equals(hatPrivatschirm)) {
            this.kenntEreignisanwendung.halteAn();
        }
        dispose();
    }

    @Override
    public void focusGained(FocusEvent e) {
        Bildschirm.this.bearbeiteFokusErhalten();
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusErhalten();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusVerloren();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) && (e.getKeyCode() != 17)) {
            if ((e.isActionKey()) || (e.getKeyCode() < 32) || (e.getKeyCode() == 127)) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste((char) (e.getKeyCode() + 500));
            } else {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste(e.getKeyChar());
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteMausDruck(e.getX(), e.getY());
            Bildschirm.this.hatPanel.requestFocus();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            if (e.getClickCount() > 1) {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteDoppelKlick(e.getX(), e.getY());
            } else {
                Bildschirm.this.kenntEreignisanwendung.bearbeiteMausLos(e.getX(), e.getY());
            }
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus())) {
            Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
        }
    }

    @Override
    public void componentResized(ComponentEvent e) {
        // Bildschirm.this.fenstergroesseAnpassen();
        //System.out.println("res");

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Bildschirm.this.fensterZerstoeren();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

}
