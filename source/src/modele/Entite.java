package modele;

public abstract class Entite implements Runnable{
    private int positionX;
    private int positionY;
    private HitBox hitbox;

    public Entite(int posX, int posY, HitBox hb){
        this.positionX = posX;
        this.positionY = posY;
        this.hitbox = hb;
    }

    @Override
    public void run() {
        System.out.println("Coucou");
    }
    public int getPositionX() { return positionX; }

    public void setPositionX(int positionX) { this.positionX = positionX; }

    public int getPositionY() { return positionY; }

    public void setPositionY(int positionY) { this.positionY = positionY; }

    public HitBox getHitbox() { return hitbox; }

    public void setHitbox(HitBox hitbox) { this.hitbox = hitbox; }
}
