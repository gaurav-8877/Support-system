import { Button } from "@/components/ui/button";
import { Dialog, DialogContent, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { useState } from "react";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";
import { Users, Heart, Briefcase, Shield } from "lucide-react";

const UserRolesSection = () => {
  const roles = [
    {
      icon: Users,
      title: "Athletes",
      description: "Access mentorship, funding opportunities, and a supportive community to reach your potential.",
      features: [
        "Connect with experienced mentors",
        "Create fundraising campaigns",
        "Access training resources",
        "Join athlete community"
      ],
      cta: "Join as Athlete",
      gradient: "from-primary to-primary-glow"
    },
    {
      icon: Heart,
      title: "Mentors",
      description: "Share your expertise and help the next generation of athletes achieve their dreams.",
      features: [
        "Guide aspiring athletes",
        "Share your experience",
        "Build meaningful connections",
        "Track mentee progress"
      ],
      cta: "Become a Mentor",
      gradient: "from-success to-success/80"
    },
    {
      icon: Briefcase,
      title: "Donors & Sponsors",
      description: "Invest in athletic talent and make a lasting impact on young athletes' careers.",
      features: [
        "Support promising athletes",
        "Track funding impact",
        "Tax-deductible donations",
        "Sponsor recognition"
      ],
      cta: "Start Supporting",
      gradient: "from-warning to-warning/80"
    },
    {
      icon: Shield,
      title: "Administrators",
      description: "Manage the platform, oversee programs, and ensure quality experiences for all users.",
      features: [
        "Platform management",
        "User verification",
        "Program oversight",
        "Analytics & reporting"
      ],
      cta: "Admin Access",
      gradient: "from-destructive to-destructive/80"
    }
  ];

  const [open, setOpen] = useState(false);
  const [fullName, setFullName] = useState("");
  const [role, setRole] = useState("");

  function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    setOpen(false);
    setFullName("");
    setRole("");
  }

  return (
    <section className="py-24 bg-gradient-to-br from-backdrop to-background">
      <div className="container mx-auto px-4">
        <div className="text-center mb-16">
          <h2 className="text-4xl md:text-5xl font-bold mb-6 bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
            User Roles & Access
          </h2>
          <p className="text-xl text-muted-foreground max-w-3xl mx-auto">
            Our platform serves different user types with tailored experiences and permissions for optimal collaboration.
          </p>
        </div>

        <div className="grid md:grid-cols-2 lg:grid-cols-4 gap-8">
          {roles.map((role, index) => (
            <Card key={index} className="glass-card border-0 hover:shadow-[var(--shadow-elevated)] transition-all duration-300 scale-hover">
              <CardHeader className="text-center">
                <div className={`w-16 h-16 mx-auto bg-gradient-to-br ${role.gradient} rounded-xl flex items-center justify-center mb-4`}>
                  <role.icon className="h-8 w-8 text-white" />
                </div>
                <CardTitle className="text-xl">{role.title}</CardTitle>
              </CardHeader>
              <CardContent className="space-y-4">
                <p className="text-muted-foreground text-center text-sm">
                  {role.description}
                </p>
                
                <ul className="space-y-2">
                  {role.features.map((feature, featureIndex) => (
                    <li key={featureIndex} className="text-sm text-muted-foreground flex items-center">
                      <div className="w-1.5 h-1.5 bg-primary rounded-full mr-2 flex-shrink-0" />
                      {feature}
                    </li>
                  ))}
                </ul>
                
                <Button 
                  onClick={() => setOpen(true)}
                  className={`w-full bg-gradient-to-r ${role.gradient} text-white border-0 shadow-md hover:shadow-lg transition-all duration-300`}
                  size="sm"
                >
                  {role.cta}
                </Button>
              </CardContent>
            </Card>
          ))}
        </div>

        <div className="mt-16 text-center">
          <div className="glass-card p-8 max-w-3xl mx-auto">
            <h3 className="text-2xl font-semibold mb-4">Secure Access Management</h3>
            <p className="text-muted-foreground mb-6">
              Our platform uses role-based access control to ensure users have appropriate permissions and can interact safely within their designated areas.
            </p>
            <div className="grid md:grid-cols-3 gap-4 text-sm">
              <div className="text-center">
                <Shield className="h-8 w-8 mx-auto mb-2 text-primary" />
                <div className="font-semibold">Secure Authentication</div>
              </div>
              <div className="text-center">
                <Users className="h-8 w-8 mx-auto mb-2 text-success" />
                <div className="font-semibold">Role Verification</div>
              </div>
              <div className="text-center">
                <Heart className="h-8 w-8 mx-auto mb-2 text-warning" />
                <div className="font-semibold">Safe Interactions</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogContent>
          <DialogHeader>
            <DialogTitle>Express Interest</DialogTitle>
          </DialogHeader>
          <form onSubmit={onSubmit} className="space-y-4">
            <div className="space-y-2">
              <Label htmlFor="fullName">Full Name</Label>
              <Input id="fullName" value={fullName} onChange={(e) => setFullName(e.target.value)} required />
            </div>
            <div className="space-y-2">
              <Label htmlFor="desiredRole">Desired Role</Label>
              <Input id="desiredRole" value={role} onChange={(e) => setRole(e.target.value)} required />
            </div>
            <Button type="submit" className="w-full bg-gradient-to-r from-primary to-primary-glow">Submit</Button>
          </form>
        </DialogContent>
      </Dialog>
    </section>
  );
};

export default UserRolesSection;