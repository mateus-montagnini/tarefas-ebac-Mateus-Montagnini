/**
 * @author mateus.montagnini
 *
 * @version 1.0
 */
public class Carro {
    private int anoFabricacao;
    private String modelo;
    private String placa;

    /**
     *
     * @return retorna o ano de fabricacao do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     */
    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    /**
     * atribui o ano de fabricacao do carro
     * @param anoFabricacao ano de fabricacao do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     */

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    /**
     *
     * @return retorna o modelo do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * atribui o modelo do carro
     * @param modelo modelo do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     */

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * @return retorna a placa do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     *
     * @deprecated
     * @see String getPlacaNew()
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * atribui a placa do carro
     * @param placa placa do carro
     * @see <a href="https://www.w3schools.com/java/java_encapsulation.asp"</a>
     */

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlacaNew() {
        return placa;
    }
}
