package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class form2 {

	protected Shell shell;
	private Text txtUrl;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			form2 window = new form2();
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
		
		txtUrl = new Text(shell, SWT.BORDER);
		txtUrl.setBounds(81, 7, 311, 21);
		
		Label lblUrl = new Label(shell, SWT.NONE);
		lblUrl.setBounds(20, 10, 55, 15);
		lblUrl.setText("url:");
		
		Browser browser = new Browser(shell, SWT.NONE);
		browser.setBounds(20, 70, 372, 165);
		
		Button btnIr = new Button(shell, SWT.NONE);
		btnIr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.setUrl(txtUrl.getText());
			}
		});
		btnIr.setText("Ir");
		btnIr.setBounds(30, 34, 75, 25);
		
		Button btnRetroceder = new Button(shell, SWT.NONE);
		btnRetroceder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.back();
			}
		});
		btnRetroceder.setText("Retroceder");
		btnRetroceder.setBounds(192, 34, 75, 25);
		
		Button btnActualizar = new Button(shell, SWT.NONE);
		btnActualizar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.refresh();
			}
		});
		btnActualizar.setText("Actualizar");
		btnActualizar.setBounds(111, 34, 75, 25);
		
		Button btnAvanzar = new Button(shell, SWT.NONE);
		btnAvanzar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				browser.forward();
			}
		});
		btnAvanzar.setText("Avanzar");
		btnAvanzar.setBounds(276, 34, 75, 25);

	}
}
