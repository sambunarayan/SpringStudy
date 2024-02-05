package jp.co.jeus.SpringShellStudy.components;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class MyCommands {

	@ShellMethod("Add two integer together.")
	public int add(int a, int b) {
		return a + b;
	}
}
