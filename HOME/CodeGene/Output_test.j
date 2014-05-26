.source                  HOME.java
.class                   public HOME
.super                   java/lang/Object
.field public kitchenSwitch LHOME/classes/standard/Input;
.field public kitchenLamp1 LHOME/classes/standard/Output;
.field public kitchenLamp2 LHOME/classes/standard/Output;
.field public kitchenLamp3 LHOME/classes/standard/Output;
.field public kitchenLamps Ljava/util/ArrayList;
.field public kitchenThermostat1 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat2 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat3 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostat4 LHOME/classes/standard/AnalogInput;
.field public kitchenThermostats Ljava/util/HashMap;
.field public thermostat LHOME/classes/standard/AnalogInput;
.field public radiator LHOME/classes/standard/AnalogOutput;
.method public <init>()V
    .limit stack 15
    .limit locals 13
    aload_0
    invokespecial java/lang/Object/<init>()V
.line 2
    aload_0
    new HOME/classes/standard/Input
    dup
    bipush 1
    invokespecial HOME/classes/standard/Input.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenSwitch LHOME/classes/standard/Input;
.line 3
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 2
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp1 LHOME/classes/standard/Output;
.line 4
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 3
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp2 LHOME/classes/standard/Output;
.line 5
    aload_0
    new HOME/classes/standard/Output
    dup
    bipush 4
    invokespecial HOME/classes/standard/Output.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenLamp3 LHOME/classes/standard/Output;
.line 6
    aload_0
    new java/util/ArrayList
    dup
    invokespecial java/util/ArrayList.<init>()V
    astore 5
    aload 5
    aload_0
    getfield HOME/kitchenLamp1 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/kitchenLamp2 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    getfield HOME/kitchenLamp3 LHOME/classes/standard/Output;
    invokeinterface java/util/List.add(Ljava/lang/Object;)Z 2
    pop
    aload 5
    aload_0
    swap
    putfield HOME/kitchenLamps Ljava/util/ArrayList;
.line 9
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 5
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat1 LHOME/classes/standard/AnalogInput;
.line 10
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 6
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat2 LHOME/classes/standard/AnalogInput;
.line 11
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 7
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat3 LHOME/classes/standard/AnalogInput;
.line 12
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 8
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/kitchenThermostat4 LHOME/classes/standard/AnalogInput;
.line 13
    aload_0
    new java/util/HashMap
    dup
    invokespecial java/util/HashMap.<init>()V
    astore 10
    aload 10
    ldc "thermo1"
    aload_0
    getfield HOME/kitchenThermostat1 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo2"
    aload_0
    getfield HOME/kitchenThermostat2 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo3"
    aload_0
    getfield HOME/kitchenThermostat3 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    ldc "thermo4"
    aload_0
    getfield HOME/kitchenThermostat4 LHOME/classes/standard/AnalogInput;
    invokevirtual java/util/HashMap.put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    pop
    aload 10
    aload_0
    swap
    putfield HOME/kitchenThermostats Ljava/util/HashMap;
.line 16
    aload_0
    new HOME/classes/standard/AnalogInput
    dup
    bipush 9
    invokespecial HOME/classes/standard/AnalogInput.<init>(I)V
    aload_0
    swap
    putfield HOME/thermostat LHOME/classes/standard/AnalogInput;
.line 17
    aload_0
    new HOME/classes/standard/AnalogOutput
    dup
    bipush 10
    invokespecial HOME/classes/standard/AnalogOutput.<init>(I)V
    aload_0
    swap
    putfield HOME/radiator LHOME/classes/standard/AnalogOutput;
return
.end method

.method public Setup()V
    .limit stack 1
    .limit locals 2
.line 20
    aload_0
    invokevirtual HOME/getAverageKitchenTemperature()I
    istore 1
    return
.end method

.method public getAverageKitchenTemperature()I
    .limit stack 3
    .limit locals 6
.line 24
    bipush 10
    istore 1
.line 26
    bipush 1
    istore 2
.line 27
    Label1:
    iload 2
    bipush 4
    if_icmpgt Label2
.line 28
    aload_0
    getfield HOME/kitchenThermostats Ljava/util/HashMap;
    ldc "thermo"
    iload 2
    invokestatic java/lang/Integer.valueOf(I)Ljava/lang/Integer;
    invokevirtual java/lang/Integer.toString()Ljava/lang/String;
    astore 5
    astore 4
    new java/lang/StringBuilder
    dup
    invokespecial java/lang/StringBuilder.<init>()V
    aload 4
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    aload 5
    invokevirtual java/lang/StringBuilder.append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    invokevirtual java/lang/StringBuilder.toString()Ljava/lang/String;
    invokevirtual java/util/HashMap.get(Ljava/lang/Object;)Ljava/lang/Object;
    checkcast HOME/classes/standard/AnalogInput
    astore 5
.line 29
    iload 1
    aload 5
    getfield HOME/classes/standard/AnalogInput/value I
    iadd
    istore 1
.line 30
    iload 2
    iconst_1
    iadd
    istore 2
    goto Label1
    Label2:
.line 33
    bipush 4
    getstatic java/lang/System/out Ljava/io/PrintStream;
    bipush 4
    invokevirtual java/io/PrintStream/println(I)V
    ireturn
.end method

