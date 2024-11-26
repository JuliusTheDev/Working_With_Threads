public class Cozinheiro implements Runnable {
    private int idCozinheiro;
    private Buffer buffer;

    public Cozinheiro(int id, Buffer buffer) {
        this.idCozinheiro = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            Pedido pedido = buffer.get(idCozinheiro);

            if (pedido != null) {
                try {
                    Thread.sleep(pedido.getTempoPreparo());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}