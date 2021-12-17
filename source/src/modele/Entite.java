package modele;

public abstract class Entite {
    private int positionX;
    private int positionY;
    private HitBox hitbox;

    public Entite(int posX, int posY, HitBox hb){
        this.positionX = posX;
        this.positionY = posY;
        this.hitbox = hb;
    }

    public int getPositionX() { return positionX; }

    public void setPositionX(int positionX) { this.positionX = positionX; }

    public int getPositionY() { return positionY; }

    public void setPositionY(int positionY) { this.positionY = positionY; }

    public HitBox getHitbox() { return hitbox; }

    public void setHitbox(HitBox hitbox) { this.hitbox = hitbox; }
}
