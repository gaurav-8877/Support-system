import { Button } from "@/components/ui/button";
import { ArrowRight, Play } from "lucide-react";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useState } from "react";

const HeroSection = () => {
  const [open, setOpen] = useState(false);
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    setOpen(false);
    setName("");
    setEmail("");
  }

  return (
    <section className="relative min-h-[90vh] flex items-center justify-center overflow-hidden">
      {/* Background gradient */}
      <div className="absolute inset-0 hero-gradient" />
      
      {/* Floating orbs for visual effect */}
      <div className="absolute top-20 left-20 w-32 h-32 bg-primary/20 rounded-full blur-3xl animate-pulse" />
      <div className="absolute bottom-40 right-20 w-40 h-40 bg-accent/20 rounded-full blur-3xl animate-pulse delay-1000" />
      
      <div className="container mx-auto px-4 text-center relative z-10">
        <div className="fade-in">
          <h1 className="text-5xl md:text-7xl font-bold mb-6 bg-gradient-to-r from-foreground via-primary to-accent bg-clip-text text-transparent">
            Empowering
            <br />
            Underprivileged Athletes
          </h1>
          <p className="text-xl md:text-2xl text-muted-foreground mb-8 max-w-3xl mx-auto leading-relaxed">
            Connect talented athletes with mentors, funding opportunities, and the support they need to achieve their dreams.
          </p>
        </div>
        
        <div className="slide-up flex flex-col sm:flex-row items-center justify-center gap-4 mb-12">
          <Button onClick={() => setOpen(true)} size="lg" className="bg-gradient-to-r from-primary to-primary-glow hover:shadow-[var(--shadow-elevated)] transition-all duration-300 scale-hover">
            Start Your Journey
            <ArrowRight className="ml-2 h-5 w-5" />
          </Button>
          <Button variant="outline" size="lg" className="glass-button scale-hover">
            <Play className="mr-2 h-5 w-5" />
            Watch Stories
          </Button>
        </div>

        {/* Stats */}
        <div className="slide-up grid grid-cols-2 md:grid-cols-4 gap-8 max-w-2xl mx-auto">
          <div className="glass-card p-6 text-center scale-hover">
            <div className="text-3xl font-bold text-primary mb-2">500+</div>
            <div className="text-sm text-muted-foreground">Athletes Supported</div>
          </div>
          <div className="glass-card p-6 text-center scale-hover">
            <div className="text-3xl font-bold text-success mb-2">150+</div>
            <div className="text-sm text-muted-foreground">Active Mentors</div>
          </div>
          <div className="glass-card p-6 text-center scale-hover">
            <div className="text-3xl font-bold text-warning mb-2">$2.5M</div>
            <div className="text-sm text-muted-foreground">Funds Raised</div>
          </div>
          <div className="glass-card p-6 text-center scale-hover">
            <div className="text-3xl font-bold text-accent mb-2">95%</div>
            <div className="text-sm text-muted-foreground">Success Rate</div>
          </div>
        </div>
      </div>
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Get Started</DialogTitle>
          </DialogHeader>
          <form onSubmit={onSubmit} className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="name">Name</Label>
              <Input id="name" value={name} onChange={(e) => setName(e.target.value)} required />
            </div>
            <div className="space-y-2">
              <Label htmlFor="email">Email</Label>
              <Input id="email" type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />
            </div>
            <Button type="submit" className="w-full bg-gradient-to-r from-primary to-primary-glow">Submit</Button>
          </form>
        </DialogContent>
      </Dialog>
    </section>
  );
};

export default HeroSection;