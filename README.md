# YAJCo Examples

This repository provides several example languages created with [YAJCo](https://github.com/kpi-tuke/yajco/).  
You can download them and try them out yourself.

**Download all examples:**
[https://github.com/kpi-tuke/yajco-examples/archive/master.zip](https://github.com/kpi-tuke/yajco-examples/archive/master.zip)

You can use any Java IDE with Maven support. The examples have been tested with:

* IntelliJ IDEA
* NetBeans
* Eclipse

We recommend using **IntelliJ IDEA**, as NetBeans has issues handling generated sources and may display false error
messages even when the project builds and runs successfully. Eclipse works fine as long as you know how to run Maven
builds within it.

---

## Simple Robot Karel Language

Directory: `simple-robot`

A very simple example for controlling a robot. The robot supports two types of commands:

* Move
* Turn left

The execution of each command is displayed as a message in the standard output.

This example demonstrates several basic language concepts with a simple syntax and semantics.  
It also shows how abstract classes and interfaces can serve as extension points, as seen in the `Command` class.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-simpleRobot/simpleRobot-diagram.png)

_**Sentence example:**_

```
begin
 move
 turn-left
 move
end
```

_**Execution result:**_

```
going straight
turning left
going straight
```

---

## Robot Karel Language

Directory: `robot-karel`

A more complex example based on the Robot Karel language described
at [http://mormegil.wz.cz/prog/karel/prog_doc.htm](http://mormegil.wz.cz/prog/karel/prog_doc.htm).

The overview of all classes used for the language specification is shown in the following diagram.  
As you can see, it’s quite a complex example. It even supports creating new named instruction definitions.

Execution results in the step-by-step evaluation of instructions within a given world.  
Before each instruction is executed, the state of the world and the robot is displayed in the console.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-robotKarel/robotKarel-diagram.png)

_**Sentence example:**_

Map:

```
*******
*o   o*
*   o *
*  K  *
*******
```

Instructions:

```
BEGINNING-OF-PROGRAM
    DEFINE TURNRIGHT AS
        ITERATE 3 TIMES
            TURNLEFT
    BEGINNING-OF-EXECUTION
        MOVE
        TURNRIGHT
        MOVE
        PICKBEEPER
        TURNLEFT
        MOVE
        TURNOFF
    END-OF-EXECUTION
END-OF-PROGRAM
```

_**Execution result:**_

```
*******
*o   o*
*   o *
*  A  *
*******
Karel: posX=3, posY=3, direction=NORTH, beepers=0
Executing: yajco.robot.karel.model.instruction.Move

----------------------------------------------------------------------------------
*******
*o   o*
*  Ao *
*  K  *
*******
Karel: posX=3, posY=2, direction=NORTH, beepers=0
Executing: yajco.robot.karel.model.instruction.TurnLeft

----------------------------------------------------------------------------------
*******
*o   o*
*  <o *
*  K  *
*******
Karel: posX=3, posY=2, direction=WEST, beepers=0
Executing: yajco.robot.karel.model.instruction.TurnLeft

----------------------------------------------------------------------------------
*******
*o   o*
*  Vo *
*  K  *
*******
Karel: posX=3, posY=2, direction=SOUTH, beepers=0
Executing: yajco.robot.karel.model.instruction.TurnLeft

----------------------------------------------------------------------------------
*******
*o   o*
*  >o *
*  K  *
*******
Karel: posX=3, posY=2, direction=EAST, beepers=0
Executing: yajco.robot.karel.model.instruction.Move

----------------------------------------------------------------------------------
*******
*o   o*
*   > *
*  K  *
*******
Karel: posX=4, posY=2, direction=EAST, beepers=0
Executing: yajco.robot.karel.model.instruction.PickBeeper

----------------------------------------------------------------------------------
*******
*o   o*
*   > *
*  K  *
*******
Karel: posX=4, posY=2, direction=EAST, beepers=1
Executing: yajco.robot.karel.model.instruction.TurnLeft

----------------------------------------------------------------------------------
*******
*o   o*
*   A *
*  K  *
*******
Karel: posX=4, posY=2, direction=NORTH, beepers=1
Executing: yajco.robot.karel.model.instruction.Move

----------------------------------------------------------------------------------
*******
*o  Ao*
*     *
*  K  *
*******
Karel: posX=4, posY=1, direction=NORTH, beepers=1
Executing: yajco.robot.karel.model.instruction.TurnOff

*******
*o  Ao*
*     *
*  K  *
*******
```

---

## Math Expressions Language

Directory: `math-expressions`

A simple language for writing mathematical expressions consisting of:

* addition
* subtraction
* multiplication
* integer division
* parentheses

Each sentence is evaluated as a mathematical expression and produces a numeric result.  
Such a language could be used as a module in other languages that require arithmetic expressions.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-mathExpressions/mathExpression-diagram.png)

_**Sentence example:**_

```
(1+6/2)*30
```

_**Execution result:**_

```
Result for '(1+6/2)*30' is: 120
```

---

## Extended Math Expressions Language

Directory: `ext-math-expressions`

An extended version of the previous mathematical expression language.  
It adds more operations and demonstrates the automatically generated `Printer` feature included in YAJCo.

The result of execution is the evaluated mathematical value.  
Additionally, the parsed expression is printed using the auto-generated printer.  
Because the language supports parentheses, the printer uses them extensively (though it could be made more
sophisticated).

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-extMathExpressions/extMathExpression-diagram.png)

_**Sentence example:**_

```
2 ^ 3 * -7
```

_**Execution result:**_

```
Result: -56

Printer output:
((( 2) \^( 3)) \*( -( 7)))
```

---

## State Machine Language

Directory: `state-machine`

A simple language for describing state machines.  
It allows you to define states and transitions between them.  
This example demonstrates the use of _identifiers_ and _references_ through YAJCo’s specialized annotations.

The execution result summarizes the described state machine, including incoming and outgoing transitions for each state.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-stateMachine/stateMachine-diagram.png)

_**Sentence example:**_

```
state Ready;
state Running;
state Unsafe;

trans a : Ready -> Running;
trans b : Running -> Ready;
trans c : Running -> Unsafe;
trans d : Unsafe -> Running;
```

_**Execution result:**_

```
state Ready [outgoingTrans: a ; incomingTrans: b ];
state Running [outgoingTrans: b c ; incomingTrans: a d ];
state Unsafe [outgoingTrans: d ; incomingTrans: c ];
trans a:Ready->Running;
trans b:Running->Ready;
trans c:Running->Unsafe;
trans d:Unsafe->Running;
```

---

## Nielsen’s DESK Language

Directory: `desk-nielsen`

A language for describing simple expressions with constants.

Execution results in a transformation into an instruction set, followed by an automatically generated printer output.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-deskNielsen/deskNielsen-diagram.png)

_**Sentence example:**_

```
print x + y + 3 + 2 where x = 1, y = 2
```

_**Execution result:**_

```
--------------------- PROGRAM RESULT ---------------------
PUSH 2
PUSH 3
PUSH 2
PUSH 1
ADD
ADD
ADD

--------------------- PRINTER OUTPUT ---------------------
print(((( x) +( y)) +( 3)) +( 2)) where x = 1, y = 2
```

---

## JSON Language

Directory: `json`

A parser for the JSON format, created by one of our bachelor students as part of a YAJCo usage study.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-json/json-diagram.png)

_**Sentence example:**_

```
{
"id": 444,
"gender": "male",
"name": "John Bell",
"active": true,
"age": 345,
"hobbies": ["skiing","sleeping"]
}
```

**Result:** an internal model representing the parsed JSON structure.


---

## Imperative Language

Directory: `imperative-lang`

A generic imperative programming language with support for named functions, blocks, loops, and variables.  
This example demonstrates the wide range of possibilities offered by YAJCo.  
It is more complex but showcases most of YAJCo’s capabilities.

The result of execution depends on the input, as you can evaluate mathematical or logical expressions,
print strings, or call functions.

_**Model (class diagram):**_  
![UML class diagram](https://raw.githubusercontent.com/kpi-tuke/yajco-examples/master/yajco-example-imperativeLang/imperLang-diagram.png)

_**Sentence example:**_

```
abs(x) {
  return x < 0 ? - x : x;
}

{
  i = -10;
  while ( i <= 10 ) {
    write abs(i);
    i = i + 1;
  }
}
```

_**Execution result:**_

```
10
9
8
7
6
5
4
3
2
1
0
1
2
3
4
5
6
7
8
9
10
{i=11}
```
