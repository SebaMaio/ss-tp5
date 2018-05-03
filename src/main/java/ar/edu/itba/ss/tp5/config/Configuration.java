
	package ar.edu.itba.ss.tp5.config;

		/**
		* <p>Esta clase representa la estructura del archivo de configuración,
		* la cual será automáticamente completada durante el inicio del
		* sistema. La clase debe ser completamente mapeable con respecto al
		* archivo origen.</p>
		*/

	public final class Configuration {

		// Archivo de configuración origen:
		public static final String CONFIGURATION_FILENAME
			= "config.json";

		protected String output = "res/data/output.data";
		protected double delta = 0.00001;
		protected double time = 5.0;
		protected int fps = 50;
		protected double playbackSpeed = 1.0;

		protected String integrator = "BeemanIntegrator";
		protected boolean reportEnergy = false;
		protected boolean reportTime = true;
		protected double [] radius = {0.01, 0.015};
		protected double mass = 0.01;

		protected double elasticNormal = 1.0E+3;
		protected double elasticTangent = 2.0E+3;
		protected double viscousDamping = 1.0E+2;
		protected double siloDamping = 20.0;

		protected long generator = System.nanoTime();
		protected int n = 100;
		protected double height = 1.0;
		protected double width = 0.25;
		protected double drain = 0.15;
		protected double flowRate = 0.1;

		public String getOutput() {
			return output;
		}

		public double getDelta() {
			return delta;
		}

		public double getTime() {
			return time;
		}

		public int getFPS() {
			return fps;
		}

		public double getPlaybackSpeed() {
			return playbackSpeed;
		}

		public String getIntegrator() {
			return integrator;
		}

		public boolean getReportEnergy() {
			return reportEnergy;
		}

		public boolean getReportTime() {
			return reportTime;
		}

		public double [] getRadius() {
			return radius;
		}

		public double getMass() {
			return mass;
		}

		public double getElasticNormal() {
			return elasticNormal;
		}

		public double getElasticTangent() {
			return elasticTangent;
		}

		public double getViscousDamping() {
			return viscousDamping;
		}

		public double getSiloDamping() {
			return siloDamping;
		}

		public long getGenerator() {
			return generator;
		}

		public int getN() {
			return n;
		}

		public double getHeight() {
			return height;
		}

		public double getWidth() {
			return width;
		}

		public double getDrain() {
			return drain;
		}

		public double getFlowRate() {
			return flowRate;
		}

		@Override
		public String toString() {
			return new StringBuilder(512)
					.append("\tOutput: " + output + "\n")
					.append("\tDelta: " + delta + " [s]\n")
					.append("\tTime: " + time + " [s]\n")
					.append("\tFPS: " + fps + "\n")
					.append("\tPlayback Speed: x" + playbackSpeed + "\n")
					.append("\tIntegrator: " + integrator + "\n")
					.append("\tReport Energy?: " + reportEnergy + "\n")
					.append("\tReport Time?: " + reportTime + "\n")
					.append("\tRadius: (" + radius[0] + ", " + radius[1] + ") [m]\n")
					.append("\tMass: " + mass + " [kg]\n")
					.append("\tElastic (normal): " + elasticNormal + " [N/m]\n")
					.append("\tElastic (tangent): " + elasticTangent + " [N/m]\n")
					.append("\tFluid Gamma: " + viscousDamping + " [kg/s]\n")
					.append("\tSilo Fluid Gamma: " + siloDamping + " [kg/s]\n")
					.append("\tGenerator Seed: " + generator + "\n")
					.append("\tN: " + n + " particles\n")
					.append("\tHeight: " + height + " [m]\n")
					.append("\tWidth: " + width + " [m]\n")
					.append("\tDrain Gate: " + drain + " [m]\n")
					.append("\tFlow Rate Window: " + flowRate + " [s]\n")
					.toString();
		}
	}
