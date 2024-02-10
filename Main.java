public class Main {
    public static void main(String[] args) {
        Pacman pacman = new Pacman(10, 20);

        RenderStrategy textRenderStrategy = new TextRenderStrategy();
        pacman.render(textRenderStrategy);

        RenderStrategy htmlRenderStrategy = new HtmlRenderStrategy();
        pacman.render(htmlRenderStrategy);
    }
}
