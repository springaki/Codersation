package net.codersation.vendingmachine.stockflow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.codersation.vendingmachine.Juice;
import net.codersation.vendingmachine.JuiceFactory;
import net.codersation.vendingmachine.StockReport;

public class JuiceStock {

	private List<JuiceRack> racks = new ArrayList<JuiceRack>();
	private Collection<Juice> juices = new ArrayList<>();

	public JuiceStock() {
		initialize();
	}

	private void initialize() {
		juices.add(JuiceFactory.create("コーラ"));
		juices.add(JuiceFactory.create("水"));
		juices.add(JuiceFactory.create("レッドブル"));
		for (Juice j : juices) {
			racks.add(new JuiceRack(j, 5));
		}
	}

	private JuiceRack getRack(Juice juice) {
		for (JuiceRack rack : racks) {
			if (rack.getJuice().equals(juice)) {
				return rack;
			}
		}
		throw new IllegalStateException("そんなRackはない");
	}

	public boolean isInStock(Juice juice) {
		return getRack(juice).isInStock();
	}

	public void remove(Juice juice) {
		getRack(juice).remove();
	}

	public StockReport getStockReport() {
		StockReport report = new StockReport();
		for (JuiceRack rack : racks) {
			report.put(rack.getJuice(), rack.getCount());
		}
		return report;
	}

	/**
	 * 取り扱っている商品
	 * @return
	 */
	public Collection<Juice> getJuices() {
		return juices;
	}
}
