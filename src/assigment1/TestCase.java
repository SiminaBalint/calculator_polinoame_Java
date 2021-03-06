package assigment1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class TestCase {

	@Test
	public void addTest() {
		Operations op = new Operations();
		Monomial m = new Monomial(3, 2);
		Monomial m1 = new Monomial(2, -5);
		Monomial m4 = new Monomial(2, -5);
		Monomial m3 = new Monomial(0, 2);
		List<Monomial> monomialList = new ArrayList<Monomial>();
		monomialList.add(m);
		monomialList.add(m1);
		List<Monomial> monomialList1 = new ArrayList<Monomial>();
		monomialList1.add(m3);
		monomialList1.add(m4);
		Polynomial poly1 = new Polynomial(monomialList);
		Polynomial poly2 = new Polynomial(monomialList1);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList2);
		result=op.addPolynoms(poly1, poly2);
		assertEquals("+2.0X^3-10.0X^2+2.0",op.toString(result));
	}
	@Test
	public void subTest() {
		Operations op = new Operations();
		Monomial m = new Monomial(3, 2);
		Monomial m1 = new Monomial(2, -5);
		Monomial m4 = new Monomial(2, -5);
		Monomial m3 = new Monomial(0, 2);
		List<Monomial> monomialList = new ArrayList<Monomial>();
		monomialList.add(m);
		monomialList.add(m1);
		List<Monomial> monomialList1 = new ArrayList<Monomial>();
		monomialList1.add(m3);
		monomialList1.add(m4);
		Polynomial poly1 = new Polynomial(monomialList);
		Polynomial poly2 = new Polynomial(monomialList1);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList2);
		result=op.subPolynoms(poly1, poly2);
		assertEquals("+2.0X^3-2.0",op.toString(result));
	}
	@Test
	public void mulTest() {
		Operations op = new Operations();
		Monomial m = new Monomial(3, 2);
		Monomial m1 = new Monomial(2, -5);
		Monomial m4 = new Monomial(2, -5);
		Monomial m3 = new Monomial(0, 2);
		List<Monomial> monomialList = new ArrayList<Monomial>();
		monomialList.add(m);
		monomialList.add(m1);
		List<Monomial> monomialList1 = new ArrayList<Monomial>();
		monomialList1.add(m3);
		monomialList1.add(m4);
		Polynomial poly1 = new Polynomial(monomialList);
		Polynomial poly2 = new Polynomial(monomialList1);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList2);
		result=op.mulPolynoms(poly1, poly2);
		assertEquals("-10.0X^5+25.0X^4+4.0X^3-10.0X^2",op.toString(result));
	}
	@Test
	public void derivTest() {
		Operations op = new Operations();
		Monomial m = new Monomial(3, 2);
		Monomial m1 = new Monomial(2, -5);
		List<Monomial> monomialList = new ArrayList<Monomial>();
		monomialList.add(m);
		monomialList.add(m1);
		Polynomial poly1 = new Polynomial(monomialList);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList2);
		result=op.derivPolynom(poly1);
		assertEquals("+6.0X^2-10.0X",op.toString(result));
	}
	@Test
	public void integrTest() {
		Operations op = new Operations();
		Monomial m = new Monomial(3, 2); 
		Monomial m1 = new Monomial(2, -5);
		List<Monomial> monomialList = new ArrayList<Monomial>();
		monomialList.add(m);
		monomialList.add(m1);
		Polynomial poly1 = new Polynomial(monomialList);
		List<Monomial> monomialList2 = new ArrayList<Monomial>();
		Polynomial result = new Polynomial(monomialList2);
		result=op.integrPolynom(poly1);
		assertEquals("+0.5X^4-1.67X^3",op.toString(result));
	}

}
