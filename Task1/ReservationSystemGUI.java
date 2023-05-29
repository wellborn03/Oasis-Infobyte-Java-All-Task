/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationSystemGUI {

    private boolean[] seats = new boolean[10];
    private JFrame frame;
    private JPanel mainPanel, seatMapPanel;
    private JButton viewSeatMapButton, reserveSeatButton, cancelReservationButton;
    private JLabel seatMapLabel;
    private JTextField seatNumberTextField;

    public ReservationSystemGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Online Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel(new BorderLayout());
        frame.getContentPane().add(mainPanel);

        // seat map panel
        seatMapPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        seatMapLabel = new JLabel("Current Seat Map:");
        seatMapPanel.add(seatMapLabel);
        displaySeatMap();
        mainPanel.add(seatMapPanel, BorderLayout.CENTER);

        // buttons panel
        // JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        viewSeatMapButton = new JButton("View Seat Map");
        reserveSeatButton = new JButton("Reserve Seat");
        cancelReservationButton = new JButton("Cancel Reservation");
        // mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // add action listeners to buttons
        viewSeatMapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displaySeatMap();
            }
        });

        reserveSeatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reserveSeat();
                displaySeatMap();
            }
        });

        cancelReservationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelReservation();
                displaySeatMap();
            }
        });

        // reserve/cancel reservation panel
        JPanel reserveCancelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel seatNumberLabel = new JLabel("Seat Number:");
        seatNumberTextField = new JTextField(2);
        JButton reserveButton = new JButton("Reserve");
        JButton cancelButton = new JButton("Cancel Reservation");
        reserveCancelPanel.add(seatNumberLabel);
        reserveCancelPanel.add(seatNumberTextField);
        reserveCancelPanel.add(reserveButton);
        reserveCancelPanel.add(cancelButton);
        mainPanel.add(reserveCancelPanel, BorderLayout.NORTH);

        // add action listeners to reserve/cancel buttons
        reserveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reserveSeat();
                displaySeatMap();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cancelReservation();
                displaySeatMap();
            }
        });

        // show the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void displaySeatMap() {
        seatMapLabel.setText("Current Seat Map:");
        seatMapPanel.removeAll();
        for (int i = 0; i < seats.length; i++) {
            JLabel seatLabel = new JLabel((i + 1) + "");
            if (seats[i]) {
                seatLabel.setBackground(Color.RED);
            } else {
                seatLabel.setBackground(Color.GREEN);
            }
            seatLabel.setOpaque(true);
            seatMapPanel.add(seatLabel);
        }
        seatMapPanel.revalidate();
        seatMapPanel.repaint();
    }

    private void reserveSeat() {
        try {
            int seatNumber = Integer.parseInt(seatNumberTextField.getText().trim());
            if (seatNumber < 1 || seatNumber > 10) {
                JOptionPane.showMessageDialog(frame, "Invalid seat number! Seat number should be between 1 and 10.");
            } else if (seats[seatNumber - 1]) {
                JOptionPane.showMessageDialog(frame,
                        "Seat " + seatNumber + " is already reserved! Please choose another seat.");
            } else {
                seats[seatNumber - 1] = true;
                JOptionPane.showMessageDialog(frame, "Seat " + seatNumber + " reserved successfully!");
            }
            seatNumberTextField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid seat number.");
        }
    }

    private void cancelReservation() {
        try {
            int seatNumber = Integer.parseInt(seatNumberTextField.getText().trim());
            if (seatNumber < 1 || seatNumber > 10) {
                JOptionPane.showMessageDialog(frame, "Please enter a seat number between 1 and 10.",
                        "Invalid Seat Number", JOptionPane.ERROR_MESSAGE);
            } else if (!seats[seatNumber - 1]) {
                JOptionPane.showMessageDialog(frame, "Seat " + seatNumber + " is not currently reserved.",
                        "Seat Not Reserved", JOptionPane.ERROR_MESSAGE);
            } else {
                seats[seatNumber - 1] = false;
                JOptionPane.showMessageDialog(frame, "Reservation for seat " + seatNumber + " has been cancelled.",
                        "Reservation Cancelled", JOptionPane.INFORMATION_MESSAGE);
                seatNumberTextField.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid seat number.", "Invalid Seat Number",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ReservationSystemGUI gui = new ReservationSystemGUI();
    }

}