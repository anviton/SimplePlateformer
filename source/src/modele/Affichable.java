package modele;

public abstract class Affichable {
    protected String image;
    protected Collision collisions;

    public Affichable(String image, Collision collision) {
        this.collisions = collision;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    private void setImage(String image) {
        this.image = image;
    }

    public Collision getCollisions() {
        return collisions;
    }

    private void setCollisions(Collision collisions) {
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
