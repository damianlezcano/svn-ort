package ar.com.pattern.creacional.factory.abstrac.Computers;

public class TestComputer {
	public static void main(String[] args) {
		ComputerType type = new ComputerType();

		computers computer = type.getComputer("workstation");
		System.out.println("Monitor: "
				+ computer.getMonitor().getSpecification());
		System.out.println("RAM: " + computer.getRAM().getSpecification());
		System.out.println("Processor: "
				+ computer.getProcessor().getSpecification());
	}
}
