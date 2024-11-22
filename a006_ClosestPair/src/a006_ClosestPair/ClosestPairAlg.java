package a006_ClosestPair;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClosestPairAlg extends JFrame{
    int noOfPoints;
    Point[] points;
    JPanel canvas;
    JTextField txtNo;
    JButton btnCreate, btnBrute, btnDivide;

    public ClosestPairAlg() {
        setTitle("Closest Pair Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // UI setup
        JPanel controlPanel = new JPanel();
        txtNo = new JTextField(5);
        btnCreate = new JButton("Create Points");
        btnBrute = new JButton("Brute Force");
        btnDivide = new JButton("Divide and Conquer");

        controlPanel.add(new JLabel("Number of Points:"));
        controlPanel.add(txtNo);
        controlPanel.add(btnCreate);
        controlPanel.add(btnBrute);
        controlPanel.add(btnDivide);

        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (points != null) {
                    g.setColor(Color.BLACK);
                    for (Point p : points) {
                        g.fillRect(p.x - 1, p.y - 1, 3, 3);
                    }
                }
            }
        };
        canvas.setBackground(Color.WHITE);

        add(controlPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);

        // Button Listeners
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPoints();
            }
        });

        btnBrute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long start = System.nanoTime();
                PointPair result = findClosestPairBruteForce();
                long end = System.nanoTime();
                highlightPair(result);
                JOptionPane.showMessageDialog(null, String.format("Brute Force: %d ns\nClosest Pair: (%d, %d)-(%d, %d) = %.2f",
                        end - start, result.p1.x, result.p1.y, result.p2.x, result.p2.y, result.dist));
            }
        });

        btnDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long start = System.nanoTime();
                PointPair result = findClosestPairDivideAndConquer(points, 0, points.length - 1);
                long end = System.nanoTime();
                highlightPair(result);
                JOptionPane.showMessageDialog(null, String.format("Divide and Conquer: %d ns\nClosest Pair: (%d, %d)-(%d, %d) = %.2f",
                        end - start, result.p1.x, result.p1.y, result.p2.x, result.p2.y, result.dist));
            }
        });
    }

    private void createPoints() {
        canvas.repaint();
        noOfPoints = Integer.parseInt(txtNo.getText());
        points = new Point[noOfPoints];
        Random r = new Random();

        for (int i = 0; i < noOfPoints; i++) {
            points[i] = new Point(r.nextInt(canvas.getWidth()), r.nextInt(canvas.getHeight()));
        }

        Arrays.sort(points, Comparator.comparingInt(p -> p.x));
        canvas.repaint();
    }

    private PointPair findClosestPairBruteForce() {
        double minDist = Double.MAX_VALUE;
        Point p1 = null, p2 = null;

        for (int i = 0; i < noOfPoints - 1; i++) {
            for (int j = i + 1; j < noOfPoints; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }

        return new PointPair(p1, p2, minDist);
    }

    private PointPair findClosestPairDivideAndConquer(Point[] points, int left, int right) {
        if (right - left <= 100) {  // Small problem, use brute force
            return findClosestPairBruteForce();
        }

        int mid = (left + right) / 2;
        PointPair leftPair = findClosestPairDivideAndConquer(points, left, mid);
        PointPair rightPair = findClosestPairDivideAndConquer(points, mid + 1, right);

        double d = Math.min(leftPair.dist, rightPair.dist);
        PointPair midPair = findMidRange(points, mid, d);

        return min(leftPair, rightPair, midPair);
    }

    private PointPair findMidRange(Point[] points, int mid, double d) {
        int left = 0, right = 0;

        for (int i = mid; i >= 0; i--) {
            if (points[mid].x - points[i].x > d) {
                left = i;
                break;
            }
        }

        for (int i = mid; i < points.length; i++) {
            if (points[i].x - points[mid].x > d) {
                right = i;
                break;
            }
        }

        return findClosestPairBruteForce();
    }

    private PointPair min(PointPair a, PointPair b, PointPair c) {
        if (a.dist <= b.dist && a.dist <= c.dist) return a;
        if (b.dist <= a.dist && b.dist <= c.dist) return b;
        return c;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private void highlightPair(PointPair result) {
        Graphics g = canvas.getGraphics();
        g.setColor(Color.RED);
        g.drawRect(Math.min(result.p1.x, result.p2.x) - 5, Math.min(result.p1.y, result.p2.y) - 5,
                Math.abs(result.p1.x - result.p2.x) + 10, Math.abs(result.p1.y - result.p2.y) + 10);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClosestPairAlg cp = new ClosestPairAlg();
            cp.setVisible(true);
        });
    }

    class PointPair {
        Point p1, p2;
        double dist;

        public PointPair(Point p1, Point p2, double dist) {
            this.p1 = p1;
            this.p2 = p2;
            this.dist = dist;
        }
    }
}