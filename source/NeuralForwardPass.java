// File: NeuralForwardPass.java
// Demonstrates forward pass of a simple neural network

public class NeuralForwardPass {

    // Activation functions
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static double relu(double x) {
        return Math.max(0, x);
    }

    public static double tanh(double x) {
        return Math.tanh(x);
    }

    public static void main(String[] args) {
        // Input layer (2 neurons)
        double[] inputs = {0.5, 0.8};

        // Hidden layer (2 neurons) weights and biases
        double[][] hiddenWeights = {
            {0.2, 0.4},   // weights for hidden neuron 1
            {0.3, 0.7}    // weights for hidden neuron 2
        };
        double[] hiddenBiases = {0.1, -0.3};

        // Output layer (1 neuron) weights and bias
        double[] outputWeights = {0.6, 0.9};
        double outputBias = 0.2;

        // Forward pass: Hidden layer computation
        double[] hiddenLayerOutputs = new double[2];
        for (int i = 0; i < hiddenWeights.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < inputs.length; j++) {
                sum += inputs[j] * hiddenWeights[i][j];
            }
            sum += hiddenBiases[i];
            hiddenLayerOutputs[i] = relu(sum); // using ReLU activation
        }

        // Forward pass: Output layer computation
        double outputSum = 0.0;
        for (int i = 0; i < hiddenLayerOutputs.length; i++) {
            outputSum += hiddenLayerOutputs[i] * outputWeights[i];
        }
        outputSum += outputBias;
        double finalOutput = sigmoid(outputSum); // using Sigmoid activation

        // Print results
        System.out.println("Input Layer: ");
        for (double in : inputs) System.out.print(in + " ");
        System.out.println("\nHidden Layer Outputs: ");
        for (double h : hiddenLayerOutputs) System.out.print(h + " ");
        System.out.println("\nFinal Output: " + finalOutput);
    }
}
