package at.petrak.hexcasting.api.casting.arithmetic.operator;


import at.petrak.hexcasting.api.casting.arithmetic.predicates.IotaMultiPredicate;
import at.petrak.hexcasting.api.casting.iota.Iota;

import java.util.List;
import java.util.function.BinaryOperator;

public class OperatorBinary extends Operator {
	public BinaryOperator<Iota> inner;

	public OperatorBinary(IotaMultiPredicate accepts, BinaryOperator<Iota> inner) {
		super(2, accepts);
		this.inner = inner;
	}

	@Override
	public Iterable<Iota> apply(Iterable<Iota> iotas) {
		var it = iotas.iterator();
		return List.of(inner.apply(it.next(), it.next()));
	}
}
