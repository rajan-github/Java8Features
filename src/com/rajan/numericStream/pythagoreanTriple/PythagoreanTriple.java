package com.rajan.numericStream.pythagoreanTriple;

public class PythagoreanTriple {
	private final int a;
	private final int b;
	private final int c;

	public PythagoreanTriple(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public boolean isPythagoreanTriplet() {
		return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PythagoreanTriple other = (PythagoreanTriple) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PythagoreanTriple [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}
