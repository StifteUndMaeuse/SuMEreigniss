/*     */ package sum.ereignis;
/*     */ 
/*     */ import java.awt.Component;
/*     */ import java.awt.event.ComponentAdapter;
/*     */ import java.awt.event.ComponentEvent;
/*     */ 
/*     */ class Bildschirm$ComponentRepaintAdapter extends ComponentAdapter
/*     */ {
/*     */   private Bildschirm$ComponentRepaintAdapter(Bildschirm paramBildschirm)
/*     */   {
/*     */   }
/*     */ 
/*     */   public void componentMoved(ComponentEvent event)
/*     */   {
/* 136 */     event.getComponent().repaint();
/*     */   }
/*     */ 
/*     */   public void componentResized(ComponentEvent event)
/*     */   {
/* 141 */     event.getComponent().repaint();
/*     */   }
/*     */ }

/* Location:           C:\Users\Programmieren\Java Recources\sumlibs\SuMEreignis.jar
 * Qualified Name:     sum.ereignis.Bildschirm.ComponentRepaintAdapter
 * JD-Core Version:    0.6.0
 */