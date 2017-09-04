state Ready;
state Running;
state Unsafe;

trans a : Ready -> Running;
trans b : Running -> Ready;
trans c : Running -> Unsafe;
trans d : Unsafe -> Running;
