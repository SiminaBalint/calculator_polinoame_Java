package assigment1;

import java.util.ArrayList;
import java.util.List;

import assigment1.Monomial;
import assigment1.Polynomial;

public class Operations {
	public Polynomial addPolynoms(Polynomial poly1, Polynomial poly2) {
		List<Monomial> monomialList = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList);
		List<Monomial> p1 = poly1.getMonomialList();
		List<Monomial> p2 = poly2.getMonomialList();
		for (Monomial item1 : p1) {
			boolean ok = false;
			for (Monomial item2 : p2) {
				if (item1.getPower() == item2.getPower()) {
					Monomial m = (new Monomial(item1.getPower(), item1.getCoef() + item2.getCoef()));
					monomialList.add(m);
					ok = true;
				}
			}
			if (ok == false)
				monomialList.add(item1);
		}

		for (Monomial item2 : p2) {
			boolean ok = false;
			for (Monomial item1 : p1) {
				if (item1.getPower() == item2.getPower()) {
					ok = true;
				}
			}
			if (ok == false) {
				monomialList.add(item2);
			}
		}
		result.sortByPower();
		return result;
	}

	public Polynomial subPolynoms(Polynomial poly1, Polynomial poly2) {
		List<Monomial> monomialList = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList);
		List<Monomial> p1 = poly1.getMonomialList();
		List<Monomial> p2 = poly2.getMonomialList();
		for (Monomial item1 : p1) {
			boolean ok = false;
			for (Monomial item2 : p2) {
				if (item1.getPower() == item2.getPower()) {
					Monomial m = (new Monomial(item1.getPower(), item1.getCoef() - item2.getCoef()));
					monomialList.add(m);
					ok = true;
				}
			}
			if (ok == false)
				monomialList.add(item1);
		}

		for (Monomial item2 : p2) {
			boolean ok = false;
			for (Monomial item1 : p1) {
				if (item1.getPower() == item2.getPower()) {
					ok = true;
				}
			}
			if (ok == false) {
				monomialList.add(new Monomial(item2.getPower(), -item2.getCoef()));
			}
		}
		result.sortByPower();
		return result;
	}

	public Polynomial mulPolynoms(Polynomial poly1, Polynomial poly2) {
		List<Monomial> monomialList = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList);
		List<Monomial> monomialList1 = new ArrayList<Monomial>();
		Polynomial result1 = new Polynomial(monomialList1);
		List<Monomial> p1 = poly1.getMonomialList();
		List<Monomial> p2 = poly2.getMonomialList();
		for (Monomial item1 : p1)
			for (Monomial item2 : p2) {
				Monomial m = new Monomial(item1.getPower() + item2.getPower(), item1.getCoef() * item2.getCoef());
				monomialList.add(m);
			}
		result.sortByPower();
		int i = monomialList.get(0).getPower();
		float a = 0;
		for (Monomial item : monomialList) {
			if (item.getPower() == i) {
				a += item.getCoef();
				System.out.println(i);
			} else {
				Monomial m = new Monomial(i, a);
				monomialList1.add(m);
				a = item.getCoef();
				i = item.getPower();
			}
		}
		Monomial m = new Monomial(monomialList.get(monomialList.size() - 1).getPower(),
				monomialList.get(monomialList.size() - 1).getCoef());
		monomialList1.add(m);
		result1.sortByPower();
		return result1;

	}

	public Polynomial derivPolynom(Polynomial poly) {
		List<Monomial> monomialList = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList);
		List<Monomial> p = poly.getMonomialList();
		for (Monomial item : p) {
			if (item.getPower() == 0) {
				Monomial m = new Monomial(0, 0);
				monomialList.add(m);
			} else {
				Monomial m = new Monomial(item.getPower() - 1, item.getCoef() * item.getPower());
				monomialList.add(m);
			}
		}
		result.sortByPower();
		return result;
	}

	public Polynomial integrPolynom(Polynomial poly) {
		List<Monomial> monomialList = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList);
		List<Monomial> p = poly.getMonomialList();
		for (Monomial item : p) {
			float a = item.getCoef() / (item.getPower() + 1);
			a = (float) (Math.round(a * 100.0) / 100.0);
			Monomial m = new Monomial(item.getPower() + 1, a);
			monomialList.add(m);
		}
		result.sortByPower();
		return result;
	}
	public String toString(Polynomial poly) {
		String result = new String();
		result = "";
		List<Monomial> p = poly.getMonomialList();
		for (Monomial item : p) {
			if (item.getCoef() > 0) {
				result = result.concat("+" + Float.toString(item.getCoef()));
			} else if (item.getCoef() < 0) {
				result = result.concat(Float.toString(item.getCoef()));
			} else if (item.getCoef() == 0) {
				// result=result + "+0";
			}
			if (item.getPower() == 1) {
				result = result.concat("X");
			} else if (item.getPower() > 0) {
				if (item.getCoef() == 0) {
				} else {
					result = result.concat("X^" + Integer.toString(item.getPower()));
				}
			} else if (item.getPower() == 0) {
				// result=result+"X";
			}
			if (result=="") {
				result="0";
			}
		}
		return result;
	}
}
