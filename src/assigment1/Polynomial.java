package assigment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import assigment1.Monomial;
import assigment1.Polynomial;

public class Polynomial {

	private List<Monomial> monomialList = new ArrayList<Monomial>();

	public List<Monomial> getMonomialList() {
		return monomialList;
	}

	public void setMonomialList(List<Monomial> monomialList) {
		this.monomialList = monomialList;
	}

	public Polynomial(List<Monomial> monomialList) {
		this.monomialList = monomialList;
	}

	public Polynomial createPoly(String scan) {
		int index = scan.indexOf("^");
		String sub = scan.substring(index + 1);
		int maxPower = Integer.parseInt(sub.split("[-+]")[0]);
		for (int i = maxPower; i >= 0; i--) {
			Monomial m = new Monomial(0, 0);
			if (scan.contains("^" + i)) {
				String[] splitByPower = scan.split("\\^" + i);
				if (splitByPower.length > 1) {
					scan = splitByPower[1];
				}
				String s = splitByPower[0].split("X")[0];
				int coef;
				if (s.contains("+")) {
					coef = Integer.parseInt(s.substring(1));
					m.setCoef(coef);
					m.setPower(i);
					monomialList.add(m);
				} else {
					coef = Integer.parseInt(s);
					m.setCoef(coef);
					m.setPower(i);
					monomialList.add(m);
				}
			}

		}
		Polynomial result = new Polynomial(monomialList);
		return result;
	}

	public Polynomial sortByPower() {
		this.getMonomialList().sort(Comparator.comparing(Monomial::getPower).reversed());
		return this;
	}
}
