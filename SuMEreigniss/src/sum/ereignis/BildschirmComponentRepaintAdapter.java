package sum.ereignis;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

class BildschirmComponentRepaintAdapter implements ComponentListener {

    private Bildschirm zBildschirm;

    public BildschirmComponentRepaintAdapter(Bildschirm paramBildschirm) {
        this.zBildschirm = paramBildschirm;
        paramBildschirm.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent event) {
        zBildschirm.repaint();
        event.getComponent().repaint();

    }

    @Override
    public void componentResized(ComponentEvent event) {
        zBildschirm.repaint();
        event.getComponent().repaint();
    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
