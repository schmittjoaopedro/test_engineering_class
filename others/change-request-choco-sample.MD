Hello,

I'm using choco to solve dynamic constraint programming. I need to create dynamic variables and constraints based on other dynamic variables and constraints (multi-level dynamic creation).
In the following sample, I expect to create variable y after x value being defined, and z after y value being defined. In the end, the values of x, y and z must be equal to 2.

I need to handle this kind of instantiation for performance reasons. In my context, the model is composed of various components, and some of these are only instantiated given criteria. Therefore, I can reduce the solution space instantiating only the components relevant for a given set of input values.

```java
Model model = new Model();
// Static variable and constraint
IntVar x = model.intVar("x", 1, 3);
x.eq(2).post();
x.addMonitor((var, evt) -> {
	if (var.asIntVar().getValue() == 2) {
		// First dynamic variable and constraint
		IntVar y = model.intVar("y", 1, 3);
		x.eq(2).imp(y.eq(2)).post(); // It didn't works
		//x.eq(y).post(); // It works
		y.addMonitor((var2, evt2) -> {
			if (var2.asIntVar().getValue() == 2) {
				// Second dynamic variable and constraint
				IntVar z = model.intVar("z", 1, 3);
				y.eq(z).post();
				model.getSolver().propagate();
			}
		});
		model.getSolver().propagate();
	}
});
model.getSolver().propagate();
System.out.println(model);
```

If I execute this program using `x.eq(y).post()` it works fine, but when I execute `x.eq(2).imp(y.eq(2)).post()` a NullPointerException is thrown. Following, the stack trace:

```java
Exception in thread "main" java.lang.NullPointerException
	at org.chocosolver.solver.propagation.PropagationEngine.propagate(PropagationEngine.java:171)
	at org.chocosolver.solver.Solver.propagate(Solver.java:627)
	at net.weg.configurator.requirements.gcsp.GcspErrorApp.lambda$null$0(GcspErrorApp.java:24)
	at org.chocosolver.solver.variables.impl.AbstractVariable.notifyMonitors(AbstractVariable.java:336)
	at org.chocosolver.solver.variables.impl.AbstractVariable.notifyPropagators(AbstractVariable.java:330)
	at org.chocosolver.solver.variables.impl.BitsetIntVarImpl.instantiateTo(BitsetIntVarImpl.java:384)
	at org.chocosolver.solver.constraints.reification.PropXeqCReif.propagate(PropXeqCReif.java:45)
	at org.chocosolver.solver.propagation.PropagationEngine.propagate(PropagationEngine.java:180)
	at org.chocosolver.solver.Solver.propagate(Solver.java:627)
	at net.weg.configurator.requirements.gcsp.GcspErrorApp.lambda$main$1(GcspErrorApp.java:27)
	at org.chocosolver.solver.variables.impl.AbstractVariable.notifyMonitors(AbstractVariable.java:336)
	at org.chocosolver.solver.variables.impl.AbstractVariable.notifyPropagators(AbstractVariable.java:330)
	at org.chocosolver.solver.variables.impl.BitsetIntVarImpl.instantiateTo(BitsetIntVarImpl.java:384)
	at org.chocosolver.solver.constraints.unary.PropEqualXC.propagate(PropEqualXC.java:43)
	at org.chocosolver.solver.propagation.PropagationEngine.execute(PropagationEngine.java:216)
	at org.chocosolver.solver.propagation.PropagationEngine.activatePropagators(PropagationEngine.java:200)
	at org.chocosolver.solver.propagation.PropagationEngine.propagate(PropagationEngine.java:164)
	at org.chocosolver.solver.Solver.propagate(Solver.java:627)
	at net.weg.configurator.requirements.gcsp.GcspErrorApp.main(GcspErrorApp.java:30)
```

I think this is a bug and I have no idea about the cause (I'm new on choco-solver). Besides that, it's not clear in documentation if this approach is the better one to handle this kind of dynamic environment. 

Environment
* Choco-solver version: 4.10.2
* Java version: 1.8.0_161
