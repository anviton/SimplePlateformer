package modele;

public abstract class Affichable {
    protected String image;
    protected HitBox collisions;

    public Affichable(String image, HitBox collision) {
        this.collisions = collision;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    private void setImage(String image) {
        this.image = image;
    }

    public HitBox getCollisions() {
        return collisions;
    }

    private void setCollisions(HitBox collisions) {
        this.collisions = collisions;
    }

    @Override
    public String toString() {
        return "Affichable{" +
                "image='" + image  +
                ", collisions=" + collisions +
                '}';
    }
}
