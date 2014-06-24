/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.awt.AlphaComposite;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.FocusListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseMotionAdapter;
/*     */ import java.awt.event.WindowAdapter;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.io.PrintStream;
/*     */ import javax.swing.JComponent;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class Bildschirm extends JFrame
/*     */ {
/*     */   public static Bildschirm hatPrivatschirm;
/*     */   private JPanel hatPanel;
/*     */   public static Bildschirm topFenster;
/*     */   protected static int zFensternummer;
/*     */   private Ereignisanwendung kenntEreignisanwendung;
/*  28 */   private Color zHintergrundfarbe = Color.white;
/*  29 */   private Image dbImage = null;
/*  30 */   private Graphics2D dbGraphics = null;
/*  31 */   private int zHoehe = 0; private int zBreite = 0;
/*  32 */   private boolean zHatFocus = true;
/*  33 */   private boolean zHatGezeichnet = false;
/*     */   private boolean zMitDoubleBuffering;
/*     */ 
/*     */   public Bildschirm()
/*     */   {
/* 152 */     this(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Bildschirm(boolean pMitDoubleBuffering)
/*     */   {
/* 162 */     this(0, 0, -1, -1, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe)
/*     */   {
/* 176 */     this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/* 192 */     this(pLinks, pOben, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   public Bildschirm(int pBreite, int pHoehe)
/*     */   {
/* 203 */     this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), false);
/*     */   }
/*     */ 
/*     */   public Bildschirm(int pBreite, int pHoehe, boolean pMitDoubleBuffering)
/*     */   {
/* 215 */     this(0, 0, pBreite, pHoehe, "SuM-Fenster " + (zFensternummer + 1), pMitDoubleBuffering);
/*     */   }
/*     */ 
/*     */   protected Bildschirm(int pLinks, int pOben, int pBreite, int pHoehe, String pName, boolean pMitDoubleBuffering)
/*     */   {
/* 232 */     super(pName);
/* 233 */     if (hatPrivatschirm == null)
/* 234 */       hatPrivatschirm = this;
/* 235 */     this.zMitDoubleBuffering = pMitDoubleBuffering;
/* 236 */     this.kenntEreignisanwendung = Ereignisanwendung.hatSuMPrivateAnwendung;
/* 237 */     String osName = System.getProperty("os.name");
/* 238 */     if (osName.toLowerCase().startsWith("mac os"))
/* 239 */       System.setProperty("apple.laf.useScreenMenuBar", "true");
/* 240 */     setJMenuBar(new JMenuBar());
/* 241 */     this.hatPanel = ((JPanel)getContentPane());
/* 242 */     this.hatPanel.setLayout(null);
/* 243 */     if (osName.toLowerCase().startsWith("mac os"))
/* 244 */       this.hatPanel.setBounds(0, 0, 2000, 2000);
/*     */     else
/* 246 */       this.hatPanel.setBounds(0, 22, 2000, 2022);
/* 247 */     this.hatPanel.setOpaque(true);
/* 248 */     addWindowListener(new FensterTester(null));
/* 249 */     addComponentListener(new GroesseTester(null));
/* 250 */     this.hatPanel.addMouseMotionListener(new MausBeweger(null));
/* 251 */     this.hatPanel.addMouseListener(new MausTaster(null));
/* 252 */     this.hatPanel.addKeyListener(new TastenTester(null));
/* 253 */     this.hatPanel.addFocusListener(new FokusReaktor(null));
/* 254 */     if (pBreite == -1)
/*     */     {
/* 256 */       Dimension dimension = getToolkit().getScreenSize();
/* 257 */       pBreite = dimension.width - 20;
/* 258 */       pHoehe = dimension.height - 60;
/*     */     }
/* 260 */     setBounds(pLinks, pOben, pBreite, pHoehe);
/* 261 */     setVisible(true);
/* 262 */     getJMenuBar().setVisible(true);
/* 263 */     fenstergroesseAnpassen();
/* 264 */     setSize(getWidth() - breite() + pBreite, getHeight() - hoehe() + pHoehe);
/*     */ 
/* 267 */     if (this.zMitDoubleBuffering)
/*     */     {
/* 269 */       this.dbImage = createImage(getSize().width, getSize().height);
/* 270 */       this.dbGraphics = ((Graphics2D)this.dbImage.getGraphics());
/*     */     }
/* 272 */     init2DGraphics();
/* 273 */     setzeFarbe(11);
/* 274 */     bearbeiteFokusErhalten();
/* 275 */     warte(1000L);
/* 276 */     this.hatPanel.requestFocus();
/*     */   }
/*     */ 
/*     */   protected void init2DGraphics()
/*     */   {
/*     */     Graphics2D g2d;
/*     */     Graphics2D g2d;
/* 286 */     if (this.zMitDoubleBuffering)
/* 287 */       g2d = this.dbGraphics;
/*     */     else
/* 289 */       g2d = (Graphics2D)this.hatPanel.getGraphics();
/* 290 */     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
/*     */ 
/* 292 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
/*     */ 
/* 294 */     g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
/*     */ 
/* 296 */     g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/*     */ 
/* 298 */     g2d.setComposite(AlphaComposite.getInstance(3, 1.0F));
/*     */   }
/*     */ 
/*     */   public JPanel privatPanel()
/*     */   {
/* 307 */     return this.hatPanel;
/*     */   }
/*     */ 
/*     */   protected void bearbeiteFokusErhalten()
/*     */   {
/* 315 */     topFenster = this;
/*     */   }
/*     */ 
/*     */   protected void merkeGroesse(int x, int y)
/*     */   {
/* 323 */     this.zBreite = x;
/* 324 */     this.zHoehe = y;
/*     */   }
/*     */ 
/*     */   protected Graphics g()
/*     */   {
/* 332 */     if (this.zMitDoubleBuffering) {
/* 333 */       return this.dbGraphics;
/*     */     }
/* 335 */     return this.hatPanel.getGraphics();
/*     */   }
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/* 345 */     if (this.dbImage != null)
/* 346 */       g.drawImage(this.dbImage, 0, 0, this);
/*     */     else
/* 348 */       super.paint(g);
/* 349 */     for (int i = 0; i < this.hatPanel.getComponentCount(); i++)
/*     */     {
/* 351 */       Component komponente = this.hatPanel.getComponent(i);
/* 352 */       komponente.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void update(Graphics g)
/*     */   {
/* 361 */     super.update(g);
/* 362 */     if (this.zHatGezeichnet) {
/* 363 */       this.kenntEreignisanwendung.bearbeiteUpdate();
/*     */     }
/* 365 */     else if ((isVisible()) && (this.kenntEreignisanwendung.fuehrtAus()))
/*     */     {
/* 367 */       this.zHatGezeichnet = true;
/* 368 */       loescheAlles();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void zeichneDich()
/*     */   {
/* 380 */     if (this.zMitDoubleBuffering)
/* 381 */       this.hatPanel.getGraphics().drawImage(this.dbImage, 0, 0, this);
/* 382 */     for (int i = 0; i < this.hatPanel.getComponentCount(); i++)
/*     */     {
/* 384 */       Component komponente = this.hatPanel.getComponent(i);
/* 385 */       komponente.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public boolean besitztFokus()
/*     */   {
/* 395 */     return this.zHatFocus;
/*     */   }
/*     */ 
/*     */   public void setzeFokus()
/*     */   {
/* 403 */     this.hatPanel.requestFocus();
/*     */   }
/*     */ 
/*     */   public void setzeFarbe(Color pFarbe)
/*     */   {
/* 414 */     if (this.zMitDoubleBuffering)
/*     */     {
/* 416 */       this.dbGraphics.setBackground(pFarbe);
/* 417 */       this.dbGraphics.clearRect(0, 0, 2000, 2000);
/*     */     }
/*     */     else
/*     */     {
/* 421 */       this.hatPanel.setBackground(pFarbe);
/* 422 */       this.hatPanel.getGraphics().clearRect(0, 0, 2000, 2000);
/*     */     }
/* 424 */     this.zHintergrundfarbe = pFarbe;
/* 425 */     this.hatPanel.paintImmediately(0, 0, 2000, 2000);
/* 426 */     this.hatPanel.validate();
/* 427 */     for (int i = 0; i < this.hatPanel.getComponentCount(); i++)
/*     */     {
/* 429 */       Component komponente = this.hatPanel.getComponent(i);
/* 430 */       komponente.setBackground(pFarbe);
/* 431 */       komponente.repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   public void setzeFarbe(int pFarbe)
/*     */   {
/* 441 */     if (pFarbe < 0)
/* 442 */       pFarbe = 0;
/* 443 */     pFarbe %= 13;
/* 444 */     switch (pFarbe)
/*     */     {
/*     */     case 0:
/* 447 */       setzeFarbe(Color.black);
/* 448 */       break;
/*     */     case 1:
/* 450 */       setzeFarbe(Color.blue);
/* 451 */       break;
/*     */     case 2:
/* 453 */       setzeFarbe(Color.cyan);
/* 454 */       break;
/*     */     case 3:
/* 456 */       setzeFarbe(Color.darkGray);
/* 457 */       break;
/*     */     case 4:
/* 459 */       setzeFarbe(Color.gray);
/* 460 */       break;
/*     */     case 5:
/* 462 */       setzeFarbe(Color.green);
/* 463 */       break;
/*     */     case 6:
/* 465 */       setzeFarbe(Color.lightGray);
/* 466 */       break;
/*     */     case 7:
/* 468 */       setzeFarbe(Color.magenta);
/* 469 */       break;
/*     */     case 8:
/* 471 */       setzeFarbe(Color.orange);
/* 472 */       break;
/*     */     case 9:
/* 474 */       setzeFarbe(Color.pink);
/* 475 */       break;
/*     */     case 10:
/* 477 */       setzeFarbe(Color.red);
/* 478 */       break;
/*     */     case 11:
/* 480 */       setzeFarbe(Color.white);
/* 481 */       break;
/*     */     case 12:
/* 483 */       setzeFarbe(Color.yellow);
/*     */     }
/*     */   }
/*     */ 
/*     */   public void loescheAlles()
/*     */   {
/* 493 */     setzeFarbe(this.zHintergrundfarbe);
/*     */   }
/*     */ 
/*     */   protected void warte(long zeit)
/*     */   {
/*     */     try
/*     */     {
/* 503 */       Thread.sleep(zeit);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 507 */       System.out.println(e.toString());
/*     */     }
/*     */   }
/*     */ 
/*     */   public Color hintergrundfarbe()
/*     */   {
/* 516 */     return this.zHintergrundfarbe;
/*     */   }
/*     */ 
/*     */   public void doUpdate(JComponent pKomponente)
/*     */   {
/* 524 */     pKomponente.paintImmediately(0, 0, pKomponente.getWidth(), pKomponente.getHeight());
/*     */ 
/* 526 */     pKomponente.validate();
/*     */   }
/*     */ 
/*     */   public int breite()
/*     */   {
/* 535 */     return this.zBreite;
/*     */   }
/*     */ 
/*     */   public int hoehe()
/*     */   {
/* 544 */     return this.zHoehe;
/*     */   }
/*     */ 
/*     */   public void verstecke()
/*     */   {
/* 552 */     setVisible(false);
/*     */   }
/*     */ 
/*     */   public void zeige()
/*     */   {
/* 560 */     setVisible(true);
/*     */   }
/*     */ 
/*     */   public void immerNachVorn()
/*     */   {
/* 569 */     setAlwaysOnTop(true);
/*     */   }
/*     */ 
/*     */   public void nachVorn()
/*     */   {
/* 578 */     toFront();
/*     */   }
/*     */ 
/*     */   public void nachHinten()
/*     */   {
/* 587 */     toBack();
/*     */   }
/*     */ 
/*     */   public void gibFrei()
/*     */   {
/* 595 */     fensterZerstoeren();
/*     */   }
/*     */ 
/*     */   private void fenstergroesseAnpassen()
/*     */   {
/* 603 */     merkeGroesse(this.hatPanel.getVisibleRect().width, this.hatPanel.getVisibleRect().height);
/* 604 */     if (this.zMitDoubleBuffering)
/*     */     {
/* 606 */       this.dbImage = createImage(getSize().width, getSize().height);
/* 607 */       this.dbGraphics = ((Graphics2D)this.dbImage.getGraphics());
/* 608 */       init2DGraphics();
/* 609 */       setzeFarbe(this.zHintergrundfarbe);
/*     */     }
/*     */   }
/*     */ 
/*     */   private void fensterZerstoeren()
/*     */   {
/* 618 */     if (equals(hatPrivatschirm))
/* 619 */       this.kenntEreignisanwendung.halteAn();
/* 620 */     dispose();
/*     */   }
/*     */ 
/*     */   private class FokusReaktor
/*     */     implements FocusListener
/*     */   {
/*     */     private FokusReaktor()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void focusGained(FocusEvent e)
/*     */     {
/* 126 */       Bildschirm.this.bearbeiteFokusErhalten();
/* 127 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/* 130 */         Bildschirm.access$402(Bildschirm.this, true);
/* 131 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusErhalten();
/*     */       }
/*     */     }
/*     */ 
/*     */     public void focusLost(FocusEvent e)
/*     */     {
/* 137 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/* 140 */         Bildschirm.access$402(Bildschirm.this, false);
/* 141 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteFokusVerloren();
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class TastenTester extends KeyAdapter
/*     */   {
/*     */     private TastenTester()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void keyPressed(KeyEvent e)
/*     */     {
/* 110 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()) && (e.getKeyCode() != 17))
/*     */       {
/* 113 */         if ((e.isActionKey()) || (e.getKeyCode() < 32) || (e.getKeyCode() == 127))
/*     */         {
/* 115 */           Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste((char)(e.getKeyCode() + 500));
/*     */         }
/*     */         else
/* 118 */           Bildschirm.this.kenntEreignisanwendung.bearbeiteTaste(e.getKeyChar());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MausTaster extends MouseAdapter
/*     */   {
/*     */     private MausTaster()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseEntered(MouseEvent e)
/*     */     {
/*  79 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/*  81 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
/*     */       }
/*     */     }
/*     */ 
/*     */     public void mousePressed(MouseEvent e) {
/*  86 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/*  89 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteMausDruck(e.getX(), e.getY());
/*  90 */         Bildschirm.this.hatPanel.requestFocus();
/*     */       }
/*     */     }
/*     */ 
/*     */     public void mouseReleased(MouseEvent e)
/*     */     {
/*  96 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/*  98 */         if (e.getClickCount() > 1) {
/*  99 */           Bildschirm.this.kenntEreignisanwendung.bearbeiteDoppelKlick(e.getX(), e.getY());
/*     */         }
/*     */         else
/* 102 */           Bildschirm.this.kenntEreignisanwendung.bearbeiteMausLos(e.getX(), e.getY());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class MausBeweger extends MouseMotionAdapter
/*     */   {
/*     */     private MausBeweger()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void mouseDragged(MouseEvent e)
/*     */     {
/*  62 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/*  64 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
/*     */       }
/*     */     }
/*     */ 
/*     */     public void mouseMoved(MouseEvent e) {
/*  69 */       if ((Bildschirm.this.kenntEreignisanwendung != null) && (Bildschirm.this.kenntEreignisanwendung.fuehrtAus()))
/*     */       {
/*  71 */         Bildschirm.this.kenntEreignisanwendung.bearbeiteMausBewegt(e.getX(), e.getY());
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   private class GroesseTester extends ComponentAdapter
/*     */   {
/*     */     private GroesseTester()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void componentResized(ComponentEvent e)
/*     */     {
/*  48 */       Bildschirm.this.fenstergroesseAnpassen();
/*  49 */       e.getComponent().repaint();
/*     */     }
/*     */ 
/*     */     public void componentMoved(ComponentEvent e)
/*     */     {
/*  54 */       e.getComponent().repaint();
/*     */     }
/*     */   }
/*     */ 
/*     */   private class FensterTester extends WindowAdapter
/*     */   {
/*     */     private FensterTester()
/*     */     {
/*     */     }
/*     */ 
/*     */     public void windowClosing(WindowEvent e)
/*     */     {
/*  40 */       Bildschirm.this.fensterZerstoeren();
/*     */     }
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Bildschirm
 * JD-Core Version:    0.6.0
 */