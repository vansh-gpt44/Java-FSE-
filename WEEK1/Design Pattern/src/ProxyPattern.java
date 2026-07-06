public class ProxyPattern {

    interface Image {
        void display();
    }

    static class RealImage implements Image {

        private String fileName;

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from remote server: " + fileName);
        }

        @Override
        public void display() {
            System.out.println("Displaying image: " + fileName);
        }
    }

    static class ProxyImage implements Image {

        private String fileName;
        private RealImage realImage;

        public ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void display() {

            // Lazy Initialization
            if (realImage == null) {
                realImage = new RealImage(fileName);
            } else {
                System.out.println("Using cached image: " + fileName);
            }

            realImage.display();
        }
    }

    public static void main(String[] args) {

        Image image = new ProxyImage("Nature.jpg");

        System.out.println("First Display:");
        image.display();

        System.out.println();

        System.out.println("Second Display:");
        image.display();
    }
}