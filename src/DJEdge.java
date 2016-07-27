/**
 * Created by adamli on 7/26/16.
 */
public class DJEdge {
    DJNode from;
    DJNode to;
    int weight;

    DJEdge(DJNode from, DJNode to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
