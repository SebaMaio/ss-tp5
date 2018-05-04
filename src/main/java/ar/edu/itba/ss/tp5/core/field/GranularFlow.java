
	package ar.edu.itba.ss.tp5.core.field;

	import java.util.List;

	import ar.edu.itba.ss.tp4.core.Vector;
	import ar.edu.itba.ss.tp4.interfaces.ForceField;
	import ar.edu.itba.ss.tp5.config.Configuration;
	import ar.edu.itba.ss.tp5.core.GranularParticle;
	import ar.edu.itba.ss.tp5.core.NeighbourCache;

	public class GranularFlow<T extends GranularParticle>
		implements ForceField<T> {

		protected final NeighbourCache cache;
		protected final EarthGravity<T> gravity;
		protected final ContactForce<T> contact;
		protected final DryFrictionForce<T> friction;

		public GranularFlow(final Configuration configuration) {
			this.cache = NeighbourCache.ofDeep(2)
				.space(configuration.getWidth(), configuration.getHeight())
				.interactionRadius(configuration.getRadius()[1])
				.build();
			this.gravity = new EarthGravity<>();
			this.contact = new ContactForce<>(configuration, cache);
			this.friction = new DryFrictionForce<>(configuration, cache);
		}

		@Override
		public Vector apply(
				final List<T> state,
				final T body) {
			
			return gravity.apply(state, body)
					.add(contact.apply(state, body))
					.add(friction.apply(state, body));
		}

		@Override
		public boolean isVelocityDependent() {
			return true;
		}

		@Override
		public boolean isConservative() {
			return false;
		}

		@Override
		public Vector derivative1(
				final List<T> state,
				final T body) {
			return gravity.derivative1(state, body)
					.add(contact.derivative1(state, body))
					.add(friction.derivative1(state, body));
		}

		@Override
		public Vector derivative2(
				final List<T> state,
				final T body) {
			return gravity.derivative2(state, body)
					.add(contact.derivative2(state, body))
					.add(friction.derivative2(state, body));
		}

		@Override
		public Vector derivative3(
				final List<T> state,
				final T body) {
			return gravity.derivative3(state, body)
					.add(contact.derivative3(state, body))
					.add(friction.derivative3(state, body));
		}

		@Override
		public double energyLoss(final double time) {
			return gravity.energyLoss(time) +
					contact.energyLoss(time) +
					friction.energyLoss(time);
		}

		@Override
		public double potentialEnergy(final T body) {
			return gravity.potentialEnergy(body) +
					contact.potentialEnergy(body) +
					friction.potentialEnergy(body);
		}
	}
