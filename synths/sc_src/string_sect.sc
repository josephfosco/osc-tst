(
SynthDef("string-sect", {
	arg freq=440, vol=1, attack=0.3, sustain=1.0, release=0.3, gate=1.0,
	    done=0;

	var out, env, sound;
	env = Env.asr(attackTime: attack, sustainLevel: sustain, releaseTime: release,
		          curve: [-3, 1, -2]);
	sound = LPF.ar((Mix.new([Pulse.ar(freq: freq, width: ((SinOsc.kr(3) * 0.4) + 0.5)),
		                     VarSaw.ar(freq: (freq * 1.01), width:0)]) * 0.3),
	               freq: 2000);

	out = sound * EnvGen.kr(envelope: env, gate: gate, levelScale: vol, doneAction: done);
	OffsetOut.ar([0, 1], out);
}
)
).add;

a=Synth("string-sect", ["freq", 493.88])

a.set("gate", 0)

a.set("gate", 1)

a.set("done", Done.freeSelf)

a.free
