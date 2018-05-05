
	package ar.edu.itba.ss.tp5.io;

	import static java.util.stream.Collectors.groupingBy;

	import java.io.FileNotFoundException;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.PrintWriter;
	import java.nio.file.Files;
	import java.nio.file.Paths;
	import java.util.Stack;

	import ar.edu.itba.ss.tp5.config.Configuration;

	public class FlowFile {
		public static boolean generate(final Configuration configuration) {
			final String filename = configuration.getOutput() + ".drain";
			final double maxTime = configuration.getTime();
			final double window = configuration.getFlowRate();
			try (final PrintWriter output = new PrintWriter(
					new FileWriter(configuration.getOutput() + ".flow"))) {
				final Stack<Integer> lastStep = new Stack<>();
				lastStep.push(0);
				Files.lines(Paths.get(filename))
					.map(line -> Double.parseDouble(line.split("\\s")[0]))
					.collect(groupingBy(time -> window * Math.ceil((time/window))))
					.entrySet()
					.stream()
					.sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
					.forEachOrdered(entry -> {
						final double time = entry.getKey();
						final int step = (int) Math.ceil((time/window));
						for (int i = lastStep.pop(); i < step; ++i) {
							output.write((i * window) + " " + 0 + "\n");
						}
						output.write(time + " " +
								(entry.getValue().size()/window) + "\n");
						lastStep.push(step + 1);
					});
				final int step = (int) Math.ceil((maxTime/window));
				for (int i = lastStep.pop(); i <= step; ++i) {
					output.write((i * window) + " " + 0 + "\n");
				}
				return true;
			}
			catch (final FileNotFoundException exception) {
				System.out.println(
					"El archivo de drenaje no existe.");
			}
			catch (final IOException exception) {
				System.out.println(
					"No se pudo crear el archivo de flujo.");
			}
			return false;
		}
	}
