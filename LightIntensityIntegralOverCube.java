import javax.swing.JOptionPane;

public class IntensityIntegralsHW {
	public static void main(String[]args)
	{
		int n = Integer.parseInt(JOptionPane.showInputDialog
				("Input n for n x n squares(accuracy):"));
		double r = Double.parseDouble(JOptionPane.showInputDialog
				("Input r for distance from point light to "
						+ "center of cube face:"));
		double in = Double.parseDouble(JOptionPane.showInputDialog
				("Input intensity of light "
						+ "(as n aproaches infinity total light will "
						+ "equal this value):"));
		
		if(n%2 == 1) oddSide(n , r, in);
		else evenSide(n, r, in);
	}
	public static void oddSide(int n, double r, double in)
	{
		double[][] fluxStorage = new double[((n-1)/2)+1][((n-1)/2)+1];
		
		for(int i = (n-1)/2; i >= 0; i--)
		{
			for(int j = (n-1)/2; j >= 0; j--)
			{
				
				
				double cofToCoa = Math.sqrt(Math.pow((r*j*2)/n, 2)
						+ Math.pow((r*i*2)/n, 2));
				
				double distance = Math.sqrt(Math.pow(cofToCoa, 2)
						+ Math.pow(r, 2));
				
				double angle = Math.atan(cofToCoa / r);
				
				double intensity = in/(4*Math.PI*Math.pow(distance, 2));
				
				double fluxOnSquare = intensity * Math.pow
						(((2*r)/n), 2) * Math.cos(angle);
				
				fluxStorage[i][j] = fluxOnSquare;
				System.out.println("("+i+","+j+"): cofToCoa: "+cofToCoa+
						" distance: "+distance+" intensity: "+intensity+
						" angle: "+((angle*180)/Math.PI)+" flux/square: "
						+fluxOnSquare);
			}
		}
		double sumFaceFlux = 0;
		for(int i = (n-1)/2; i >= 0; i--)
		{
			for(int j = (n-1)/2; j > 0; j--)
			{
				sumFaceFlux += fluxStorage[i][j];
			}
		}
		sumFaceFlux *= 4;
		sumFaceFlux += fluxStorage[0][0];
		System.out.println("Sum of flux on one Face: "+sumFaceFlux);
		System.out.println("Sum of flux through entire cube: "
				+sumFaceFlux*6);
	}
	public static void evenSide(int n, double r, double in)
	{
		double[][] fluxStorage = new double[n/2][n/2];
		
		for(int i = (n/2)-1; i >= 0; i--)
		{
			for(int j = (n/2)-1; j >= 0; j--)
			{
				
				
				double cofToCoa = Math.sqrt(Math.pow(((r*j*2)/n)+(r/n), 2)
						+ Math.pow(((r*i*2)/n)+(r/n), 2));
				
				double distance = Math.sqrt(Math.pow(cofToCoa, 2)
						+ Math.pow(r, 2));
				
				double angle = Math.atan(cofToCoa / r);
				
				double intensity = in/(4*Math.PI*Math.pow(distance, 2));
				
				double fluxOnSquare = intensity * Math.pow
						(((2*r)/n), 2) * Math.cos(angle);
				
				fluxStorage[i][j] = fluxOnSquare;
				System.out.println("("+i+","+j+"): cofToCoa: "+cofToCoa+
						" distance: "+distance+" intensity: "+intensity+
						" angle: "+((angle*180)/Math.PI)+" flux/square: "
						+fluxOnSquare);
			}
		}
		double sumFaceFlux = 0;
		for(int i = (n-1)/2; i >= 0; i--)
		{
			for(int j = (n-1)/2; j >= 0; j--)
			{
				sumFaceFlux += fluxStorage[i][j];
			}
		}
		sumFaceFlux *= 4;
		System.out.println("Sum of flux on one Face: "+sumFaceFlux);
		System.out.println("Sum of flux through entire cube: "
				+sumFaceFlux*6);
	}
	
}
