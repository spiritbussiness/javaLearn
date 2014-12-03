import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class Calc {

	protected Shell shell;
	private Text num1;
	private Text num2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calc window = new Calc();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		num1 = new Text(shell, SWT.BORDER);
		num1.setBounds(32, 51, 112, 19);
		
		num2 = new Text(shell, SWT.BORDER);
		num2.setBounds(32, 120, 112, 19);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(32, 31, 92, 14);
		lblNewLabel.setText("First Number:");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(32, 100, 112, 14);
		lblNewLabel_1.setText("Second Number: ");
		
		final Label answer = new Label(shell, SWT.NONE);
		answer.setBounds(35, 204, 60, 14);
		answer.setText("Answer:");
		
		Button plusButton = new Button(shell, SWT.NONE);
		plusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1, number2;
				try {
					number1 = Integer.parseInt(num1.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shell, "Error", "Bad number");
					return;
				}
				try {
					number2 = Integer.parseInt(num2.getText());
				}
				catch (Exception exc) {
					MessageDialog.openError(shell, "Error", "Bad number");
					return;
				}
				int ans = number1 + number2;
				answer.setText("Answer: " + ans);
			}
		});
		plusButton.setBounds(29, 158, 56, 28);
		plusButton.setText("+");
		
		

	}
}
