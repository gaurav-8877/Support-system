import { Button } from "@/components/ui/button";
import { Users, Heart, TrendingUp, User } from "lucide-react";

const Header = () => {
  return (
    <header className="glass-card sticky top-0 z-50 w-full backdrop-blur-lg">
      <div className="container mx-auto px-4 py-4">
        <div className="flex items-center justify-between">
          <div className="flex items-center space-x-2">
            <div className="h-8 w-8 rounded-lg bg-gradient-to-br from-primary to-primary-glow flex items-center justify-center">
              <Heart className="h-5 w-5 text-white" />
            </div>
            <span className="text-xl font-bold bg-gradient-to-r from-primary to-accent bg-clip-text text-transparent">
              PlayerCare
            </span>
          </div>
          
          <nav className="hidden md:flex items-center space-x-8">
            <a href="#mentorship" className="text-muted-foreground hover:text-primary transition-colors duration-300">
              Mentorship
            </a>
            <a href="#funding" className="text-muted-foreground hover:text-primary transition-colors duration-300">
              Funding
            </a>
            <a href="#stories" className="text-muted-foreground hover:text-primary transition-colors duration-300">
              Success Stories
            </a>
            <a href="#about" className="text-muted-foreground hover:text-primary transition-colors duration-300">
              About
            </a>
          </nav>

          <div className="flex items-center space-x-3">
            <Button variant="ghost" size="sm" className="glass-button">
              <User className="h-4 w-4 mr-2" />
              Sign In
            </Button>
            <Button size="sm" className="bg-gradient-to-r from-primary to-primary-glow shadow-[var(--shadow-glass)]">
              Get Started
            </Button>
          </div>
        </div>
      </div>
    </header>
  );
};

export default Header;