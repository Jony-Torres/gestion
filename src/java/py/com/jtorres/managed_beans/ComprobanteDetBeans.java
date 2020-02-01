package py.com.jtorres.managed_beans;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import py.com.jtorres.entidades.ComprobantesDetalle;
/**
 *
 * @author jonathan.torres
 */
@Named(value = "comprobanteDetBeans")
@ManagedBean
public class ComprobanteDetBeans {
    private static List<ComprobantesDetalle> listaCompDetalle = new ArrayList<>();
    private ComprobantesDetalle compDet;
    public ComprobanteDetBeans() {
        /*listaCompDetalle=new ArrayList<>();
        listaCompDetalle.add(new ComprobantesDetalle("PRUEBA1"));
        listaCompDetalle.add(new ComprobantesDetalle("PRUEBA2"));
        listaCompDetalle.add(new ComprobantesDetalle("PRUEBA3"));
        listaCompDetalle.add(new ComprobantesDetalle("PRUEBA4"));
        listaCompDetalle.add(new ComprobantesDetalle("PRUEBA5"));*/
        compDet = new ComprobantesDetalle();
    }
    public List<ComprobantesDetalle> getListaCompDetalle() {
        return listaCompDetalle;
    }
    public void agregarComp(){
        listaCompDetalle.add(compDet);
        compDet = new ComprobantesDetalle();
    }
    public void eliminarComp(ComprobantesDetalle comp){
        listaCompDetalle.remove(comp);
    }
    public ComprobantesDetalle getCompDet() {
        return compDet;
    }
    public void setCompDet(ComprobantesDetalle compDet) {
        this.compDet = compDet;
    }
    
}
