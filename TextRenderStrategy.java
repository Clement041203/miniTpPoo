// Interface pour la stratégie de rendu
interface RenderStrategy {
    void render(int[] position);
}

// Stratégie de rendu en mode texte
class TextRenderStrategy implements RenderStrategy {
    @Override
    public void render(int[] position) {
        System.out.println("Pacman position: (" + position[0] + ", " + position[1] + ") - Rendered as '@'");
    }
}

// Stratégie de rendu en mode HTML
class HtmlRenderStrategy implements RenderStrategy {
    @Override
    public void render(int[] position) {
        System.out.println("<div style='position: absolute; top: " + position[1] + "px; left: " + position[0] + "px;'>Pacman</div>");
    }
}

// Classe Pacman
class Pacman {
    private int[] position;

    public Pacman(int x, int y) {
        this.position = new int[]{x, y};
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }

    public void render(RenderStrategy renderStrategy) {
        renderStrategy.render(this.position);
    }
}
