package edu.pdx.cs410J.saras3;

import edu.pdx.cs410J.AbstractAppointment;
import edu.pdx.cs410J.AbstractAppointmentBook;
//import edu.pdx.cs410J.AppointmentBookDumper;
//import edu.pdx.cs410J.AppointmentBookParser;

import java.util.ArrayList;
import java.util.Collection;


/**
 * This class represents an appointment book which consists of multiple
 * appointments for a particular owner.
 *
 * @author Saraswathi Datar
 */
public class AppointmentBook extends AbstractAppointmentBook <Appointment>  {

    String Ownername;
    private Collection<Appointment> appointments = new ArrayList<>();

    /**
     * Returns the name of the owner of this particular appointment book
     *
     * @return    returns Owner name as a String
     */
    @Override
    public String getOwnerName(){
        return this.Ownername;
    }

    /**
     * Returns all of the appointments belonging to this
     * appointment book as a collection of Appointments
     */
    @Override
    public Collection<Appointment> getAppointments(){
        return this.appointments;
    }

    /**
     * Adds an appointment to this particular appointment book
     */
    @Override
    public void addAppointment(Appointment var1) {
         this.appointments.add(var1);
    }
}
