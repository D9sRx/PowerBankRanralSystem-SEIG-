import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class PowerbankSelected implements ItemListener {

    String selectedPowerBank;

    @Override
    public void itemStateChanged(ItemEvent e) {

        try {
            PowerBankUsage powerBankUsage = new PowerBankUsage();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        selectedPowerBank = (String) PowerBankUsage.comboBox.getSelectedItem();

        RentalEvent.selectedPowerBank = selectedPowerBank;



    }
}
